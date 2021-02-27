package vocabulary.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.util.Callback;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import vocabulary.storage.*;
import vocabulary.util.Data;
import vocabulary.util.Helper;

public class ControllerShowData {

    @FXML
    private TableColumn<Data, String> columnEn;

    @FXML
    private TableColumn<Data, String> columnRu;

    @FXML
    private RadioButton radioPreInter;

    @FXML
    private TableView<Data> tableView;

    @FXML
    private RadioButton radioInter;

    @FXML
    private RadioButton radioIrreg;

    @FXML
    private RadioButton radioPhraseVerbs;

    @FXML
    private Button btnExit;

    @FXML
    private RadioButton radioElem;

    @FXML
    private RadioButton radioHeap;

    @FXML
    private ToggleGroup group1;

    @FXML
    private Label lblCount;

    private Storage storage;

    @FXML
    public void initialize() {
        columnEn.setCellValueFactory(new PropertyValueFactory<>("value"));
        columnRu.setCellValueFactory(new PropertyValueFactory<>("key"));
        Callback myCellFactory = new MyCellFactory();
        columnEn.setCellFactory(myCellFactory);
        columnRu.setCellFactory(myCellFactory);
        storage = new StorageElementary();
        updateTable();
        new Thread(() -> group1.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (radioElem.isSelected()) storage = new StorageElementary();
            else if (radioPreInter.isSelected()) storage = new StoragePreIntermediate();
            else if (radioInter.isSelected()) storage = new StorageIntermediate();
            else if (radioIrreg.isSelected()) storage = new StorageIrregularVerbs();
            else if (radioHeap.isSelected()) storage = new StorageHeap();
            else if (radioPhraseVerbs.isSelected()) storage = new StoragePhraseVerbs();

            updateTable();
        })).start();
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        Helper.closePreviewAndShowNextWindow(btnExit, "windowMain.fxml");
    }

    private void updateTable() {
        Platform.runLater(() -> {
            tableView.refresh();
            tableView.scrollTo(0);
            lblCount.setText(storage.getStorage().size() + "");
        });
        ObservableList<Data> observableList = FXCollections.observableArrayList();
        DualHashBidiMap<String, String> dualHashBidiMap = storage.getStorage();
        for (String key : dualHashBidiMap.keySet()) {
            observableList.add(new Data(key, dualHashBidiMap.get(key)));
        }
        observableList.sort((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()));
        tableView.setItems(observableList);
    }

    private class MyCellFactory implements Callback<TableColumn, TableCell> {

        @Override
        public TableCell call(TableColumn param) {
            return new TableCell<Data, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        setFont(Font.font("Arial", 19));
                        setText(item);
                    }
                }
            };
        }
    }
}
