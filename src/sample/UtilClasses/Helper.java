package sample.UtilClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Helper {

    public static Object open(String nameWindowTo){
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try(InputStream stream = Helper.class.getResourceAsStream("/sample/fxmlFiles/"+ nameWindowTo)){
            root = loader.load(stream);
        } catch (IOException e){
            e.printStackTrace();
        }
        //Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        if (nameWindowTo.contains("Studies")) stage.setTitle("Run!");
        else stage.setTitle("Choose a section");
        stage.show();
        return loader.getController();
    }

    public static Object closePreviewAndShowNextWindow(Node anyCurrentNode, String nameWindowTo){
        if (anyCurrentNode != null) {
            Stage stage = (Stage) anyCurrentNode.getScene().getWindow();
            stage.close();
            return open(nameWindowTo);
        }
        return null;
    }

    public static void sleep(long millias){
        try {
            Thread.sleep(millias);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
