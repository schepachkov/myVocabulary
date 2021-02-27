package vocabulary.controllers;

import com.sun.istack.internal.Nullable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import vocabulary.storage.*;
import vocabulary.util.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


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

    @FXML
    private Button btnPhraseVerbs;


    private final String STUDIES_FXML = "windowStudies.fxml";
    private final String SHOW_FXML = "windowShow.fxml";


    @FXML
    void elemOnAction(ActionEvent event) {
        internalStart(StorageElementary.class);
    }

    @FXML
    void preInterOnAction(ActionEvent event) {
        internalStart(StoragePreIntermediate.class);
    }

    @FXML
    void irregOnAction(ActionEvent event) {
        internalStart(StorageIrregularVerbs.class);
    }

    @FXML
    void interOnAction(ActionEvent event) {
        internalStart(StorageIntermediate.class);
    }

    @FXML
    void heapOnAction(ActionEvent event) {
        internalStart(StorageHeap.class);
    }

    @FXML
    void phraseVerbsOnAction(ActionEvent event) {
        internalStart(StoragePhraseVerbs.class);
    }

    @Nullable
    private void internalStart(Class<?> clazz) {
        if (clazz != null) {
            ControllerStudies controllerStudies = (ControllerStudies) Helper.closePreviewAndShowNextWindow(btnPhraseVerbs, STUDIES_FXML);
            try {
                Constructor<?> constructor = clazz.getConstructor(null);
                Object obj = constructor.newInstance(null);
                if (obj instanceof Storage) {
                    Storage storage = (Storage) obj;
                    controllerStudies.setStorage(storage.getStorage());
                    Thread thread = new Thread(controllerStudies);
                    thread.setDaemon(true);
                    thread.start();
                } else {
                    throw new RuntimeException("Object isn't instance of Storage interface");
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }

        } else {
            throw new NullPointerException("Instance 'clazz' equals null");
        }
    }

    @FXML
    void showDataOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnShow, SHOW_FXML);
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        System.exit(0);
    }

}
