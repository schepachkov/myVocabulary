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

    @FXML
    private Button btnShow;

    @FXML
    private Button btnHeap;



    private final String STUDIESFXML = "windowStudies.fxml";
    private final String SHOWFXML = "windowShow.fxml";



    @FXML
    void elemOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnElem, STUDIESFXML);
        Storage storageElementary = new StorageElementary();
        controllerStudies.setStorage(storageElementary.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();

    }

    @FXML
    void preInterOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnPreInter, STUDIESFXML);
        Storage storagePreIntermediate = new StoragePreIntermediate();
        controllerStudies.setStorage(storagePreIntermediate.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void irregOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnIrreg, STUDIESFXML);
        Storage storageIrregularVerbs = new StorageIrregularVerbs();
        controllerStudies.setStorage(storageIrregularVerbs.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void interOnAction(ActionEvent event) {
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnInter, STUDIESFXML);
        Storage storageIntermediate = new StorageIntermediate();
        controllerStudies.setStorage(storageIntermediate.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void heapOnAction (ActionEvent event){
        ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnHeap, STUDIESFXML);
        Storage storageHeap = new StorageHeap();
        controllerStudies.setStorage(storageHeap.getStorage());
        Thread thread = new Thread(controllerStudies);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void showDataOnAction(ActionEvent event){
        Helper.closePreviewAndShowNextWindow(btnShow, SHOWFXML);
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        System.exit(0);
    }

}
