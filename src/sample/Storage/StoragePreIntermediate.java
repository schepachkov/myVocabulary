package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StoragePreIntermediate implements Storage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();

    static {

        // VERBS 2
        storage.put("подтверждать", "confirm");
        storage.put("расчесывать", "comb");
        storage.put("привлекать", "attract");
        storage.put("дышать", "breeze");
        storage.put("жаловаться", "complain");
        storage.put("граничить", "border");
        storage.put("посещать", "attend");
        storage.put("заканчивать", "compleate");
        storage.put("приносить пользу, извлекать выгоду", "benefit");
        storage.put("полагать, рассматривать", "consider");
        storage.put("сравнивать", "compare");
        storage.put("избегать", "avoid");

        //MARRIAGE
        storage.put("свадьба", "wedding");
        storage.put("брак, замужество, женитьба", "marriage");
        storage.put("влюбиться", "fall in love");
        storage.put("медовый месяц", "honeymoon");
        storage.put("невеста", "bride");
        storage.put("волнение, возбуждение", "excitement");
        storage.put("пара, чета", "couple");
        storage.put("обрученный, помолвленный", "engaged");
        storage.put("жениться, выходить замуж", "marry");
        storage.put("развод", "divorce");
        storage.put("церемония, обряд", "ceremony");


    }
    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
