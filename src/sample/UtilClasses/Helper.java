package sample.UtilClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {

    public static void open(String text){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Helper.class.getResource("/sample/fxmlFiles/"+ text));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static void closePreviewAndShowNextWindow(Node elem, String text){
        if (elem != null) {
            Stage stage = (Stage) elem.getScene().getWindow();
            stage.close();
            open(text);
        }
    }


    // if I want to testing my application
    public static void toConsole(String text){
        System.out.println(text);
    }
}
