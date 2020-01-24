package sample.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import sample.UtilClasses.Helper;
import sample.UtilClasses.TimeCounter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;


public class ControllerStudies implements Runnable {

    private DualHashBidiMap<String,String> storage;
    private static int storageSize = 0;
    private double forProgressInd;          //one step of the progress indicator
    private SynchronousQueue<String> synchronousQueue;
    private Queue<String> repeatQueue;       //in this queue all words in which mistaken
    private Clip clip;
    private Thread forClipThread;


    //instead of contructor of ControllerStudies class
    public void setStorage(DualHashBidiMap<String, String> storage) {
        this.storage = storage;
        storageSize = storage.size();
        synchronousQueue = new SynchronousQueue<>();
        repeatQueue = new LinkedList<>();
        forProgressInd = 1.0 / storage.size();
        createAndStartProgressBar();
        prepareToPlaySound();
    }


    @FXML
    private Label label;

    @FXML
    private TextField txtFieldForWritten;

    @FXML
    private Label labelForHint;

    @FXML
    private Label labelHi;

    @FXML
    private ProgressIndicator progressInd;

    @FXML
    private Label labelCounter;

    public Label getLabelCounter() {
        return labelCounter;
    }

    @Override
    public void run() {
        if (storageSize > 0) {
            startCounter();
            List<String> keysList = shuffleStorage();
            for (int i = 0, j = storageSize; i < j; i++) {
                checkWord(keysList.get(i));
                Helper.sleep(200);
            }

            while (!repeatQueue.isEmpty()){
                checkWord(repeatQueue.peek());
                Helper.sleep(200);
                repeatQueue.remove();
            }
            Platform.runLater(()->label.setText(" " + label.getText() + " "));      //only for change listener progress indicator. It will be refreshed to "done" on the progressBar
            TimeCounter.stopCounter();
            Helper.sleep(1500);
        }else{
            Platform.runLater(()-> {
                txtFieldForWritten.setDisable(true);
                label.setText("this section hasn't words");

            });
            Helper.sleep(3000);
        }
        Platform.runLater(()-> Helper.closePreviewAndShowNextWindow(txtFieldForWritten,"windowMain.fxml"));
    }


    private void checkWord(String key) {
        String value = storage.get(key);        //it is word which you have to input (translate your key)
        String[] strings = value.split("");
        Platform.runLater(()-> label.setText(key));
        int countMistake = 0;
        for (String s : strings) {
            boolean isMistake;      //have a mistake - true; don't have - false
            try {
                String taken = synchronousQueue.take();
                isMistake = checkMistake(s,taken);
                //give to you another chance to return input
                if (isMistake){
                    countMistake++;
                    if (countMistake > 1) {
                        circle(value);    // may be you have already mistake
                        break;
                    }
                    taken = synchronousQueue.take();
                    isMistake = checkMistake(s, taken);
                    //if you get another
                    if (isMistake) {
                        countMistake++;
                        circle(value);
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storageSize--;
        Platform.runLater(()-> txtFieldForWritten.clear());
    }


    private void circle(String value) throws InterruptedException {
        Platform.runLater(()-> {
            txtFieldForWritten.clear();
            labelHi.setText("Hint:");
            labelForHint.setText(value);
        });
        repeatQueue.add(storage.getKey(value));
        for (String s:value.split("")) {
            while (true) {
                if (!checkMistake(s,synchronousQueue.take())) break;
            }
        }
        Platform.runLater(()-> {
            labelForHint.setText("");
            labelHi.setText("");
        });
    }

    private boolean checkMistake(String s, String taken){
        if (!s.equalsIgnoreCase(taken)){
            playMusic();
            deleteLast();
            return true;
        }
        return false;
    }

    private void deleteLast (){
        Platform.runLater(()->{
            String txt = txtFieldForWritten.getText();
            if (txt.length() > 0) {
                txtFieldForWritten.setText(txt.substring(0, txt.length() - 1));
                txtFieldForWritten.positionCaret(txtFieldForWritten.getText().length());
            }
        });
    }

    private void playMusic(){
        forClipThread = new Thread(()-> {
            clip.setFramePosition(0);
            clip.start();
        });
        forClipThread.start();
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) throws InterruptedException {
        //imitation of turning off back_sapce
        if (keyEvent.getCode().toString().equals("BACK_SPACE")){
            String txt = txtFieldForWritten.getText();
            txtFieldForWritten.setText(txt + " ");
            txtFieldForWritten.positionCaret(txt.length() + 1);
        }

        if (!(keyEvent.getCode().toString().equals("TAB") || keyEvent.getCode().toString().equals("ENTER"))) {
            if (storageSize > 0 || !repeatQueue.isEmpty()) {
                if (keyEvent.getText().matches("[a-zA-Z\\s]")) {
                    synchronousQueue.put(keyEvent.getText().toLowerCase());
                } else if (!keyEvent.getText().isEmpty()) deleteLast();
            }
        }
    }

    private void createAndStartProgressBar(){
        // add changeListener. Update progress when label had changed
        Thread thread = new Thread(()-> label.textProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.isEmpty()) progressInd.setProgress(0);
            else {
                Platform.runLater(() -> {
                    double doub = progressInd.getProgress() + forProgressInd;
                    progressInd.setProgress(doub);
                });
            }
        }));
        thread.setDaemon(true);
        thread.start();
    }

    private void prepareToPlaySound(){
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        boolean flag = false;
        Path dir = null;
        if (path.contains("artifacts")){
            path = path.substring(0,path.indexOf("artifacts"));
            path += "\\production\\myVocabulary\\";
        } else if (!path.contains("production")) {
            File file = new File(path);
            dir = file.toPath().getParent();
            flag = true;
        }
        String resPath = "";
        if (flag) resPath = dir + "\\notif.wav";
        else resPath = path + "\\sample\\audio\\notif.wav";
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(resPath))){
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private List<String> shuffleStorage(){
        List<String> resList = new ArrayList<>(100);
        resList.addAll(storage.keySet());
        Collections.shuffle(resList);
        return resList;
    }

    private void startCounter() {
        TimeCounter timeCounter = new TimeCounter(this);
        timeCounter.start();
    }
}
