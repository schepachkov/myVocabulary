package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StorageIntermediate implements Storage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {
        //here new words put into the storage
        //СЛОВООБРАЗОВАНИЕ 1
        storage.put("производить впечатление; поражать", "impress");
        storage.put("помощь, содействие", "assistance");
        storage.put("точный", "accurate");
        storage.put("тревога, беспокойство", "anxiety");
        storage.put("принятие, утверждение, усыновление", "adoption");
        storage.put("помогать", "assist");
        storage.put("принимать, усыновлять", "adopt");
        storage.put("удивлять, изумлять", "astonish");
        storage.put("впечатление", "impression");
        storage.put("развлечение (not entertainment)", "amusement");
        storage.put("точность", "accuracy");
        storage.put("развлекать", "amuse");
        storage.put("удивление, изумление", "astonishment");
        storage.put("беспокойный", "anxious");

        //СЛОВООБРАЗОВАНИЕ 1
        storage.put("сотрудничать, объединяться", "cooperate");
        storage.put("смущение, беспорядок", "confusion");
        storage.put("признание", "confession");
        storage.put("сознательный, понимающий", "conscious");
        storage.put("обязательство, передача", "commitment");
        storage.put("признаваться", "confess");
        storage.put("делать вклад, содействовать", "contribute");
        storage.put("смущать, запутывать", "confuse");
        storage.put("взаимодействие, сотрудничество, объединение", "cooperation");
        storage.put("сознание, понимание", "consciousness");
        storage.put("совершить", "commit");
        storage.put("вклад, сотрудничество", "contribution");

    }
    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }

}
