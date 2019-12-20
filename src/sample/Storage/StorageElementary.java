package sample.Storage;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import sample.Controllers.ControllerStudies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StorageElementary implements Storage {
    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    private List<String> shuffleStorage(){
        List<String> resList = new ArrayList<>(100);
        resList.addAll(storage.keySet());
        Collections.shuffle(resList);
        return resList;
    }



    public void startWork(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/fxmlFiles/windowStudies.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerStudies controllerStudies = loader.getController();
        List<String> keysList = shuffleStorage();
        for (String key: keysList) {
            controllerStudies.getTxtFieldDisabled().setText(key);        //set value, which you need translete
            controlTrue(key);                                       //implement control every character and whole word
            controllerStudies.getTxtFieldDisabled().clear();
            controllerStudies.getTxtFieldForWritten().clear();
        }

    }

    private void controlTrue(String key){
        String value = storage.get(key);        //it's need to get
        //.....
    }


    static {
        //here new words put into the storage
        storage.put("говорить", "speak");
        storage.put("рассказывать", "tell");
    }


}
