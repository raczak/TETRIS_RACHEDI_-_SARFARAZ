import java.util.ArrayList;

/**
 * Created by zrachedi on 08/02/2017.
 */
public class Player {
    private ArrayList<String> words;
    private CommonPot potInstance;

    public Player() {
        this.words = new ArrayList<String>();
        this.potInstance = CommonPot.getInstance();
    }

    public void pullLetterFromBag() {

    }
}
