package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import sample.UtilClasses.Helper;


public class ControllerStudies {

    @FXML
    private TextField txtFieldDisabled;

    @FXML
    private TextField txtFieldForWritten;

    public TextField getTxtFieldDisabled() {
        return txtFieldDisabled;
    }


    public TextField getTxtFieldForWritten() {
        return txtFieldForWritten;
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        Helper.toConsole(keyEvent.getCode().toString());
    }
}
