import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 */
public class IaPlayer extends Player{

    public IaPlayer() {
        this.words = new ArrayList<String>();
        this.potInstance = CommonPot.getInstance();
        this.words.add(0, "je suis une IA");
    }

    public void round() {
        char IALetter = this.pullLetterFromBag();
        char IALetter2 = this.pullLetterFromBag();
        potInstance.addLetter(IALetter);
        potInstance.addLetter(IALetter2);
    }
}
