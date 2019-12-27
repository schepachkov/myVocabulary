package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Storage.*;
import sample.UtilClasses.Helper;


public class ControllerMain {

    @FXML
    private Button btnInter;

    @FXML
    private Button btnPreInter;

    @FXML
    private Button btnElem;

    @FXML
    private Button btnIrreg;


    private String nameFXML = "windowStudies.fxml";



    @FXML
    void elemOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnElem, nameFXML);
        Storage storageElementary = new StorageElementary();
        controllerStudies.setStorage(storageElementary.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();

    }

    @FXML
    void preInterOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnPreInter, nameFXML);
        Storage storagePreIntermediate = new StoragePreIntermediate();
        controllerStudies.setStorage(storagePreIntermediate.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void irregOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnIrreg, nameFXML);
        Storage storageIrregularVerbs = new StorageIrregularVerbs();
        controllerStudies.setStorage(storageIrregularVerbs.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void interOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnInter, nameFXML);
        Storage storageIntermediate = new StorageIntermediate();
        controllerStudies.setStorage(storageIntermediate.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        System.exit(63);                // just I like AMG :)
    }

}
