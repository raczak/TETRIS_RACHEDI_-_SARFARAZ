import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 * I deceided to use a singleton in order to keep
 * a single instance of the common pot for everyone
 */
public class CommonPot {
    private ArrayList<String> wordList;
    private CommonPot() {
        this.wordList = new ArrayList<String>();
    }

    /** Holder */
    private static class CommonPotHolder {
        /** Unique Instance pre-initialized */
        private final static CommonPot instance = new CommonPot();
    }

    /** Access point for unique instance of the singleton */
    public static CommonPot getInstance() {
        return CommonPotHolder.instance;
    }

    public void test(){

    }
}
