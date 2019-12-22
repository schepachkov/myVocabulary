package sample.UtilClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Helper {

    public static void open(String text){
        FXMLLoader loader = null;
        try(InputStream stream = Helper.class.getResourceAsStream("/sample/fxmlFiles/"+ text)){
            loader = new FXMLLoader();
            //loader.setLocation(Helper.class.getResource("/sample/fxmlFiles/"+ text));
            loader.load(stream);
        } catch (IOException e){
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

    public static Object getController(String nameFxml){
        FXMLLoader fxmlLoader = new FXMLLoader();
        try(InputStream stream = Helper.class.getResourceAsStream("/sample/fxmlFiles/"+ nameFxml)){
            fxmlLoader.load(stream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return fxmlLoader.getController();
    }
}
