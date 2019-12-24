package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StorageElementary implements Storage {
    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {
        //here new words put into the storage
        storage.put("остров","island");
        storage.put("лифт","elevator");
        storage.put("вниз по лестнице","downstairs");
        storage.put("потолок","ceiling");
        storage.put("вход","entrance");
        storage.put("вверх по лестнице","upstairs");
        storage.put("лестница","stair");
        storage.put("ворота","gate");
        storage.put("облако","cloud");
        storage.put("средний","average");
    }

    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
