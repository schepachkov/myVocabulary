package sample.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import sample.Storage.*;
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
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnElem, nameFXML);
        Storage storageElementary = new StorageElementary();
        controllerStudies.setStorage(storageElementary.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();

    }

    @FXML
    void preInterOnAction(ActionEvent event) {
        String nameFXML = "windowStudies.fxml";
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnInter, nameFXML);
        Storage storagePreIntermediate = new StoragePreIntermediate();
        controllerStudies.setStorage(storagePreIntermediate.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void irregOnAction(ActionEvent event) {
        String nameFXML = "windowStudies.fxml";
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnIrreg, nameFXML);
        Storage storageIrregularVerbs = new StorageIrregularVerbs();
        controllerStudies.setStorage(storageIrregularVerbs.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void interOnAction(ActionEvent event) {
        String nameFXML = "windowStudies.fxml";
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnInter, nameFXML);
        Storage storageIntermediate = new StorageIntermediate();
        controllerStudies.setStorage(storageIntermediate.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
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
