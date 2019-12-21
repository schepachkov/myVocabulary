package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StoragePreIntermediate extends AbstractStorage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {
        //here new words put into the storage

    }
    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
