package vocabulary.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Helper {

    public static Object open(String nameWindowTo){
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try(InputStream stream = Helper.class.getResourceAsStream("/vocabulary/fxml/" + nameWindowTo)){
            root = loader.load(stream);
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        setMinStageSize(stage);
        stage.setScene(new Scene(root));
        if (nameWindowTo.contains("Studies")) stage.setTitle("Run!");
        else if (nameWindowTo.contains("Main")) stage.setTitle("Choose a section");
            else if (nameWindowTo.contains("Show")){
                stage.setTitle("Read");

        }
        stage.show();
        return loader.getController();
    }

    public static Object closePreviewAndShowNextWindow(Node anyCurrentNode, String nameWindowTo){
        if (anyCurrentNode != null) {
            Stage stage = (Stage) anyCurrentNode.getScene().getWindow();
            stage.close();
            return open(nameWindowTo);
        }else throw new RuntimeException("Called node is null");

    }

    public static void sleep(long millias){
        try {
            Thread.sleep(millias);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setMinStageSize(Stage stage){
        stage.setMinHeight(460);
        stage.setMinWidth(600);
    }

    public static String getOuterPathToFile(String outerFilePath){
        String pathToProject = Helper.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String pathToGeneralDir = pathToProject.substring(0, pathToProject.indexOf("/myVocabulary"));
        return pathToGeneralDir + outerFilePath;
    }

    public static String getInternalPathToFile(String internalProjectPath){
        String fileName = internalProjectPath.substring(internalProjectPath.lastIndexOf("\\"));
        String path = Helper.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        boolean flag = false;
        Path dir = null;
        if (path.contains("artifacts")){
            path = path.substring(0,path.indexOf("artifacts"));
            path += "\\production\\myVocabulary\\";
        } else if (!path.contains("production")) {
            File file = new File(path);
            dir = file.toPath().getParent();
            flag = true;
        }
        String resPath = "";
        if (flag) resPath = dir + fileName;
        else resPath = path + internalProjectPath;
        return resPath;
    }


    public static DualHashBidiMap<String, String> keyEditorForParse(DualHashBidiMap<String, String> map, boolean addSpace){  // false - remove space
        DualHashBidiMap<String, String> resultMap = new DualHashBidiMap<>();
        for (String key: map.keySet()){
            String val = map.get(key);
            if (addSpace){
                resultMap.put(key.replaceAll(",", ", "), val);
            } else {
                resultMap.put(key.replaceAll(", ", ","), val);
            }
        }
        return resultMap;
    }


    public static void fillStorage(File file, DualHashBidiMap<String, String> storage) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            StringBuilder stringBuilder = new StringBuilder();
            lines.forEach(stringBuilder::append);
            String content = stringBuilder.toString();
            Arrays.stream(content.split(", ")).forEach(pair -> {
                String[] arr = pair.split("=");
                storage.put(arr[0], arr[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
