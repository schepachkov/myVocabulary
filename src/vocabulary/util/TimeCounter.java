package vocabulary.util;

import javafx.application.Platform;
import vocabulary.controllers.ControllerStudies;

import java.text.SimpleDateFormat;

public class TimeCounter extends Thread {

    private ControllerStudies controllerStudies;
    private static boolean flag = true;

    public TimeCounter(ControllerStudies controllerStudies) {
        this.controllerStudies = controllerStudies;
        setDaemon(true);
    }


    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("H:mm:ss");
        long time = -3*60*60*1000;
        while (flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long tmpTime = time+=1000;
            Platform.runLater(()-> controllerStudies.getLabelCounter().setText(dateFormat.format(tmpTime)));
        }
        flag = true;
    }

    public static void stopCounter() {
        flag = false;
    }
}
