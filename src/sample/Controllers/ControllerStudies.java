package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import sample.Storage.Storage;
import sample.UtilClasses.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ControllerStudies {

    private DualHashBidiMap<String,String> storage;
    private String text;

    public ControllerStudies(DualHashBidiMap<String, String> storage) {
        this.storage = storage;
        text = "";
    }
    @FXML
    private TextField txtFieldDisabled;

    @FXML
    private TextField txtFieldForWritten;

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        text += keyEvent.getText();
        checkWord();
    }

    private void checkWord() {

        Helper.toConsole(text);
    }

    private List<String> shuffleStorage(){
        List<String> resList = new ArrayList<>(100);
        resList.addAll(storage.keySet());
        Collections.shuffle(resList);
        return resList;
    }

    public void startWork(){
        List<String> keysList = shuffleStorage();
        for (String key: keysList) {
            getTxtFieldDisabled().setText(key);                       //set value, which you need translete
            //controlTrue(key);                                       //implement control every character and whole word
            getTxtFieldDisabled().clear();
            getTxtFieldForWritten().clear();
        }
    }

    public TextField getTxtFieldDisabled() {
        return txtFieldDisabled;
    }


    public TextField getTxtFieldForWritten() {
        return txtFieldForWritten;
    }

}
