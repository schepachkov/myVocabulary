package sample.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import sample.UtilClasses.Helper;

import java.util.*;
import java.util.concurrent.SynchronousQueue;


public class ControllerStudies implements Runnable {

    private DualHashBidiMap<String,String> storage;
    private static int storageSize = 0;
    private SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

    public void setStorage(DualHashBidiMap<String, String> storage) {
        this.storage = storage;
        storageSize = storage.size();
    }

    @FXML
    private Label label;

    @FXML
    private TextField txtFieldForWritten;

    @FXML
    private Label labelForHint;

    @FXML
    private Label labelHi;



    private synchronized List<String> shuffleStorage(){
        List<String> resList = new ArrayList<>(100);
        resList.addAll(storage.keySet());
        Collections.shuffle(resList);
        return resList;
    }

    @Override
    public void run() {
        if (storageSize != 0) {
            List<String> keysList = shuffleStorage();
            for (String key : keysList) {
                checkWord(key);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Platform.runLater(()-> label.setText("There is nothing in this section"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(()-> Helper.closePreviewAndShowNextWindow(txtFieldForWritten,"windowMain.fxml"));
        }

    }

    private void checkWord(String key) {
        String value = storage.get(key);        //it is word which you have to input (translate your key)
        String[] strings = value.split("");
        Platform.runLater(()-> label.setText(key));
        int countMistake = 0;
        for (String s: strings) {
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
                    isMistake = checkMistake(s,taken);
                    //if you get another
                    if (isMistake){
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
        if (storageSize == 0){
            Platform.runLater(()-> Helper.closePreviewAndShowNextWindow(txtFieldForWritten,"windowMain.fxml"));
        }
    }

    private void circle(String value) throws InterruptedException {
        Platform.runLater(()-> {
            txtFieldForWritten.clear();
            labelHi.setText("Hint:");
            labelForHint.setText(value);
        });
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


    private boolean checkMistake(String s,String taken){
        if (!s.equalsIgnoreCase(taken)){
            deleteLast();
            return true;
        }
        return false;
    }

    private void deleteLast (){
        Platform.runLater(()->{ //изменение поля при ошибке : не дает пропечатать неправильный символ
            String txt = txtFieldForWritten.getText();
            if (txt.length() > 0) {
                txtFieldForWritten.setText(txt.substring(0, txt.length() - 1));
                txtFieldForWritten.positionCaret(txtFieldForWritten.getText().length());
            }
        });
    }


    // that isn't all. Because you need to implement input characters: " " and "-".
    // They will need in the "irregular verbs" and in several difficult words.
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) throws InterruptedException {
        if (keyEvent.getText().matches("[a-zA-Z]") && storageSize > 0){
            synchronousQueue.put(keyEvent.getText().toLowerCase());
        }else {
            deleteLast();
        }

    }

}
