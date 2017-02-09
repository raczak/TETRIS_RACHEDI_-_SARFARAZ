import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zrachedi on 09/02/2017.
 */
public abstract class Player {
    protected ArrayList<String> words;
    protected CommonPot potInstance;

    protected char pullLetterFromBag() {
        Random rand = new Random();
        char randLetter = (char)(rand.nextInt(26) + 'a');
        return randLetter;
    }
    abstract void round();
}
