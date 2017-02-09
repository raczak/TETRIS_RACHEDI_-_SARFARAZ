import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 */
public class IaPlayer extends Player{
    public int id = 2;
    public IaPlayer() {
        this.words = new ArrayList<String>();
        this.potInstance = CommonPot.getInstance();
    }

    public int round() {
        System.out.println("It's IA's turn !");

        potInstance.addLetter(this.pullLetterFromBag());
        potInstance.addLetter(this.pullLetterFromBag());

        String letters = " ";
        for (char item : potInstance.getLetterList()) {
            letters += " " + new StringBuilder().append(item).toString();
        }
        System.out.println("Letters in COMMON POT : "+letters);
        System.out.println("IA is trying to build a word :o");

        try {
            String testedWord = potInstance.compareToDico("chat");
            if(testedWord == ""){

            }else {
                this.words.add(testedWord);
                this.wordSuccess();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.id;
    }
    
    void wordSuccess() {
        potInstance.addLetter(this.pullLetterFromBag());
    }
}
