package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StorageElementary implements Storage {
    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {
        //here new words put into the storage
        storage.put("говорить", "speak");
        storage.put("рассказывать", "tell");
    }

    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
