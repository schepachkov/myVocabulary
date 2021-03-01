package vocabulary.storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import vocabulary.util.Helper;

import java.io.File;

public class StorageIrregularVerbs implements Storage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();


    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }


    static {
        String filePath = Helper.getInternalPathToFile("\\vocabulary\\docs\\irregularVerbs.docx");
        File file = new File(filePath);
        Helper.fillStorage(file, storage);
    }

}
