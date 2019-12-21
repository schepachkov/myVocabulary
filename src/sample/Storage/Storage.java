package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public interface Storage {
    DualHashBidiMap<String,String> getStorage();

}
