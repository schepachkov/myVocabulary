package vocabulary.storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import vocabulary.util.Helper;

import java.io.File;


public class StoragePhraseVerbs implements Storage {
    private static DualHashBidiMap<String, String> storage = new DualHashBidiMap<>();

    static {
        String filePath = Helper.getInternalPathToFile("\\vocabulary\\docs\\phraseVerbs.docx");
        File file = new File(filePath);
        Helper.fillStorage(file, storage);
    }



    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
