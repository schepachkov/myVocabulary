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

        //VOCATIONS AND ATTRACTIONS
        storage.put("досуг, свободное время","leisure");
        storage.put("водопад","waterfall");
        storage.put("сельская местность","countryside");
        storage.put("лагерь","camp");
        storage.put("песок","sand");
        storage.put("побережье","coast");
        storage.put("пейзаж","scenery");
        storage.put("путешествовать автотранспортом","hitchhike");
        storage.put("берег","shore");
        storage.put("ландшафт, пейзаж","landscape");
        storage.put("экспедиция","expedition");
        storage.put("курорт","resort");

        //ART AND ENTERTAINMENT

        storage.put("комедия","comedy");
        storage.put("агенство","agency");
        storage.put("выставка","exhibition");
        storage.put("фольклор, народный","folk");
        storage.put("зритель, публика","audience");
        storage.put("праздник, фестиваль","festival");
        storage.put("художественная литература","fiction");
        storage.put("мультфильм, кино","animation");
        storage.put("документальный фильм","documentary");
        storage.put("цирк","circus");

        //ART AND ENTERTAINMENT 1
        storage.put("студия","studio");
        storage.put("боевик, триллер","thriller");
        storage.put("скульптура","sculpture");
        storage.put("интерес","interest");
        storage.put("литература","literature");
        storage.put("эффектное зрелище","spectacular");
        storage.put("удовольствие","pleasure");
        storage.put("поэзия","poetry");
        storage.put("мыльная опера, сериал","soap opera");
        storage.put("оркестр","orchestra");

        //GRAMMAR
        storage.put("артикль, статья","article");
        storage.put("наклонение; настроение","mood");
        storage.put("произношение","pronunciation");
        storage.put("запятая","comma");
        storage.put("местоимение","pronoun");
        storage.put("время; натянутый","tense");
        storage.put("простой","simple");
        storage.put("пунктуация","punctuation");
        storage.put("речь","speech");
        storage.put("ударение; напряжение","stress");
        storage.put("страдательный, пассивный","passive");
        storage.put("предлог","preposition");
        storage.put("прямой","direct");

        //TEXT AND BOOKS

        storage.put("персонаж, характер","character");
        storage.put("заключение","conclusion");
        storage.put("деталь","detail");
        storage.put("исправление","correction");
        storage.put("объяснение","explanation");
        storage.put("описание","description");
        storage.put("глава (в книге)","chapter");
        storage.put("брошюра","brochure");
        storage.put("загаловок","title");
        storage.put("сочинение, произведение","composition");

        //TEXT AND BOOKS 1
        storage.put("тема","topic");
        storage.put("основной","main");
        storage.put("роман","novel");
        storage.put("выпуск, издание","issue");
        storage.put("перевод","translation");
        storage.put("упоминание, ссылка","mention");
        storage.put("интервью, беседа","interview");
        storage.put("блок","unit");
        storage.put("публиковать","publish");
        storage.put("сцена, эпизод","scene");
        storage.put("фраза","phrase");
        storage.put("обзор, рецензия","review");
        storage.put("том, книга","volume");

        //MEDICINE
        storage.put("болезнь (not illness)","disease");
        storage.put("аптека","drugstore");
        storage.put("кашель","cough");
        storage.put("боль (син. pain)","ache");
        storage.put("скорая помощь","ambulance");
        storage.put("капля","drop");
        storage.put("инвалид","disabled");
        storage.put("критический случай","emergency");
        storage.put("рак (\"болезнь\")","cancer");

        //MEDICINE - 1
        storage.put("шок, удар","shock");
        storage.put("слабый","weak");
        storage.put("болезнь (not disease)","illness");
        storage.put("срочный, неотложный","urgent");
        storage.put("грипп","flu");
        storage.put("рецепт, прописанное лекарство","prescription");
        storage.put("выздоравливать","recover");
        storage.put("пациент, больной","patient");
        storage.put("сердечный приступ","heart attack");
        storage.put("жар, лихорадка","fever");

        //BODY
        storage.put("улыбка","smile");
        storage.put("плечо","shoulder");
        storage.put("горло","throat");
        storage.put("язык","tongue");
        storage.put("усы","mustache");
        storage.put("вес","weight");
        storage.put("губа","lip");
        storage.put("голос","voice");
        storage.put("висок","temple");

        //BODY - 1
        storage.put("локоть","elbow");
        storage.put("щека","cheek");
        storage.put("лоб","forehead");
        storage.put("подбородок","chin");
        storage.put("фигура, телосложение","figure");
        storage.put("колено","knee");
        storage.put("щиколотка, лодыжка","ankle");
        storage.put("пятка","heel");
        storage.put("ступня","foot");
        storage.put("рост","height");


    }
    @Override
    public DualHashBidiMap<String, String> getStorage() {
        return storage;
    }
}
