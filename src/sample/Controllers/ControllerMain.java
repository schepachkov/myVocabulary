package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import sample.Storage.StorageElementary;
import sample.UtilClasses.Helper;

import java.io.IOException;

public class ControllerMain {

    @FXML
    private Button btnInter;

    @FXML
    private Button btnPreInter;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnElem;

    @FXML
    private Button btnIrreg;

    @FXML
    private Button btnExit;



    @FXML
    void elemOnAction(ActionEvent event) {
        String nameFXML = "windowStudies.fxml";
        Helper.closePreviewAndShowNextWindow(btnElem, nameFXML);
        StorageElementary storageElementary = new StorageElementary();
        ControllerStudies controllerStudies = (ControllerStudies) Helper.getController(nameFXML);
        controllerStudies.setStorage(storageElementary.getStorage());
        controllerStudies.startWork();

    }

    @FXML
    void preInterOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnPreInter,"windowStudies.fxml");
    }

    @FXML
    void irregOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnIrreg,"windowStudies.fxml");
    }

    @FXML
    void interOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnInter,"windowStudies.fxml");
    }



    @FXML
    void addOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnAdd, "windowAdd.fxml");
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        System.exit(63);                // just I like AMG :)
    }

}
