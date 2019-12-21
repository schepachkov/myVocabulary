package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StorageIntermediate implements Storage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {
        //here new words put into the storage

    }
    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
