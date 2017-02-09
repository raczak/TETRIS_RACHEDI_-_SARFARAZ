import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zrachedi on 08/02/2017.
 */
public class User extends Player {
    public int id = 1;
    public User() {
        this.words = new ArrayList<String>();
        this.potInstance = CommonPot.getInstance();
    }

    int round() {
        System.out.println("It is your turn !");

        potInstance.addLetter(this.pullLetterFromBag());
        potInstance.addLetter(this.pullLetterFromBag());

        String letters = " ";
        for (char item : potInstance.getLetterList()) {
            letters += " " + new StringBuilder().append(item).toString();
        }
        System.out.println("Letters in COMMON POT : "+letters);

        System.out.println("Try to build a word :");
        String word = this.sc.nextLine();
        try {
            String testedWord = potInstance.compareToDico(word);
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
