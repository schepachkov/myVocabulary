package vocabulary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vocabulary.util.Helper;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/windowMain.fxml"));
        primaryStage.setTitle("Vocabulary");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Helper.setMinStageSize(primaryStage);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
