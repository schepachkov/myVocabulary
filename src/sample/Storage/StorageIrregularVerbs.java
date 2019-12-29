package sample.Storage;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StorageIrregularVerbs implements Storage {

    private static DualHashBidiMap<String,String> storage = new DualHashBidiMap<>();


    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }


    static {
        //here new words put into the storage
        storage.put("начинать","begin began begun");
        storage.put("ломать, прерываться","break broke broken");
        storage.put("становиться","become became become");
        storage.put("строить","build built built");
        storage.put("приносить","bring brought brought");

        storage.put("покупать","buy bought bought");
        storage.put("резать","cut cut cut");
        storage.put("выбирать","choose chose chosen");
        storage.put("стоить","cost cost cost");
        storage.put("приходить","come came come");

        storage.put("есть","eat ate eaten");
        storage.put("пить","drink drank drunk");
        storage.put("ездить","drive drove driven");
        storage.put("рисовать","draw drew drawn");
        storage.put("мечтать","dream dreamt dreamt");

        storage.put("летать","fly flew flown");
        storage.put("бороться, драться","fight fought fought");
        storage.put("находить","find found found");
        storage.put("падать","fall fell fallen");
        storage.put("чувствовать","feel felt felt");

        storage.put("идти, ходить","go went gone");
        storage.put("забывать","forget forgot forgotten");
        storage.put("получить, доставать","get got got");
        storage.put("прощать","forgive forgave forgiven");
        storage.put("давать","give gave given");

        storage.put("расти","grow grew grown");
        storage.put("иметь","have had had");
        storage.put("причинять боль, болеть","hurt hurt hurt");
        storage.put("слышать","hear heard heard");
        storage.put("держать","hold held held");

        storage.put("класть, накрывать","lay laid laid");
        storage.put("узнавать, учить","learn learnt learnt");
        storage.put("держать, хранить","keep kept kept");
        storage.put("знать","know knew known");
        storage.put("вести","lead led led");

        storage.put("оставлять, покидать","leave left left");
        storage.put("лежать","lie lay lain");
        storage.put("терять, проигрывать","lose lost lost");
        storage.put("позволять","let let let");
        storage.put("делать","make made made");

        storage.put("вставать, подниматься","rise rose risen");
        storage.put("сказать","say said said");
        storage.put("видеть","see saw seen");
        storage.put("продавать","sell sold sold");
        storage.put("искать","seek sought sought");

        storage.put("бегать","run ran run");
        storage.put("читать","read read read");
        storage.put("класть, положить","put put put");
        storage.put("встерчать","meet met met");
        storage.put("платить","pay paid paid");

        storage.put("иметь в виду, означать","mean meant meant");
        storage.put("светить, сиять","shine shone shone");
        storage.put("показывать","show showed shown");
        storage.put("сидеть","sit sat sat");
        storage.put("отпарвлять, посылать","send sent sent");

        storage.put("петь","sing sang sung");
        storage.put("стоять","stand stood stood");
        storage.put("говорить","speak spoke spoken");
        storage.put("пахнуть, чувствовать запах","smell smelt smelt");
        storage.put("спать","sleep slept slept");

        storage.put("проводить, тратить","spend spent spent");
        storage.put("учить, обучать","teach tought tought");
        storage.put("рассказывать, говорить","tell told told");
        storage.put("плавать","swim swam swum");
        storage.put("брать","take took taken");

        storage.put("красть","steal stole stolen");
        storage.put("выигрывать","win won won");
        storage.put("носить","wear wore worn");
        storage.put("понимать","understand understood understood");
        storage.put("думать","think thought thought");

        storage.put("бросать","throw threw thrown");
        storage.put("писать","write wrote written");
        storage.put("бить","beat beat beaten");
        storage.put("добиваться, предлагать цену","bid bid bid");
        storage.put("кровоточить","bleed bled bled");

        storage.put("возникать, появляться","arise arose arisen");
        storage.put("кусать","bite bit bitten");
        storage.put("гнуть, наклонять","bend bent bent");
        storage.put("дуть","blow blew blown");
        storage.put("транслировать, передавать","broadcast broadcast broadcast");

        storage.put("взрываться","burst burst burst");
        storage.put("распределять, снабжать, тороговать","deal dealt dealt");
        storage.put("ползти","creep crept crept");
        storage.put("замерзать, замораживать","freeze froze frozen");
        storage.put("нырять","dive dove dived");

        storage.put("вешать, висеть","hang hung hung");
        storage.put("кормить","feed fed fed");
        storage.put("запрещать","forbid forbade forbidden");
        storage.put("копать","dig dug dug");
        storage.put("прятать","hide hid hidden");

        storage.put("прыгать, перепрыгивать","leap leapt leapt");
        storage.put("шить","sew sewed sewed");
        storage.put("наклоняться, опираться","lean leant leant");
        storage.put("освобождать, избавляться","rid rid rid");
        storage.put("ехать(верхом)","ride rode ridden");

        storage.put("скользить","slide slid slid");
        storage.put("разливать","spill spilt spilt");
        storage.put("прясть, крутить","spin spun spun");
        storage.put("сжимать, сокращаться","shrink shrank shrunk");
        storage.put("тонуть","sink sank sunk");

        storage.put("кляться, ругаться","swear swore sworn");
        storage.put("расщеплять","split split split");
        storage.put("портить","spoil spoilt spoilt");
        storage.put("рвать","tear tore torn");
        storage.put("прикалывать, приклеивать","stick stuck stuck");

        storage.put("терпеть, выполнять что-либо","abide abode abode");
        storage.put("затерять, заложить","mislay mislaid mislaid");
        storage.put("связывать, привязывать","bind bound bound");
        storage.put("случаться","befall befell befallen");
        storage.put("умолять","beseech besought besought");

        storage.put("обитать, жить","dwell dwelt dwelt");
        storage.put("ослышаться","mishear misheard misheard");
        storage.put("неправильно понять","misunderstand misunderstood misunderstood");
        storage.put("отнимать, отказываться","withdraw withdrew withdrawn");
        storage.put("стричь, срезать","shear sheared shorn");

        storage.put("ткать, сплетать","weave wove woven");
        storage.put("мести, подметать","sweep swept swept");
        storage.put("распространять, намазывать","spread spread spread");
        storage.put("скручивать, мучать","wring wrung wrung");
    }

}
