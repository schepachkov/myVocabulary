package sample.UtilClasses;

//ONLY for output of my tableView in the ControllerShowData.class
public class Data {
    private String key;
    private String value;

    public Data(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
