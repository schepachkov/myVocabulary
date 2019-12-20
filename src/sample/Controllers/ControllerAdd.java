package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.UtilClasses.Helper;

public class ControllerAdd {

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtEn;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtRu;



    @FXML
    void addOnAction(ActionEvent event) {
        // At first need to put a new word to myMap after to return in the main window.
        //**put**
        Helper.closePreviewAndShowNextWindow(btnAdd, "windowMain.fxml");
    }

    @FXML
    void cancelOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnCancel, "windowMain.fxml");
    }

}
