import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zrachedi on 08/02/2017.
 */
public class User extends Player {

    public User() {
        this.words = new ArrayList<String>();
        this.potInstance = CommonPot.getInstance();
        this.words.add(0, "je suis réel");
    }

    void round() {
        char p1Letter = this.pullLetterFromBag();
        char p1Letter2 = this.pullLetterFromBag();
        potInstance.addLetter(p1Letter);
        potInstance.addLetter(p1Letter2);
    }
}
