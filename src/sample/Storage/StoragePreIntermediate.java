package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StoragePreIntermediate implements Storage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {
        //here new words put into the storage
        storage.put("Прежде всего","first of all");

    }
    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
