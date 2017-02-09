import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 * I deceided to use a singleton in order to keep
 * a single instance of the common pot for everyone
 */
public class CommonPot {
    private ArrayList<Character> letterList;
    private CommonPot() {
        this.letterList = new ArrayList<Character>();
    }

    /** Holder */
    private static class CommonPotHolder {
        /** Unique Instance pre-initialized */
        private final static CommonPot instance = new CommonPot();
    }

    public ArrayList<Character> getLetterList() {
        return letterList;
    }

    /** Access point for unique instance of the singleton */
    public static CommonPot getInstance() {
        return CommonPotHolder.instance;
    }

    public void addLetter(char word) {
        this.letterList.add(word);
    }
}
