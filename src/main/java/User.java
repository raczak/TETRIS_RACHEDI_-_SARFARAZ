import com.sun.deploy.util.ArrayUtil;

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

        int choice = this.sc.nextInt();
        switch (choice) {
            case 1:
                this.OnlyCommonPotWords();
                break;
            case 2:
                if (this.words.size()>0) {
                    this.MyWords();
                }else {
                    System.out.println("You haven't word yet ");
                }
                break;
            case 3:
                this.OpponentWords();
                break;
            default:
                this.OnlyCommonPotWords();
        }
        return this.id;
    }

    void OnlyCommonPotWords() {
        System.out.println("Try to build a word :");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        try {
            String testedWord = potInstance.compareToDico(word);
            if(testedWord == ""){
                System.out.println("Looseeeer, your french word doesn't exist :(\n");
            }else {
                //We add the word to player's collection
                this.words.add(testedWord);
                System.out.println("Word : '" + testedWord + "' is correct ! You can pull another letter :D\n");
                this.wordSuccess(testedWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void MyWords() {
        System.out.println("Use one of your words and complete it with Common Pot");

        String words = " ";
        for (String item : this.words) {
            words += item;
        }
        System.out.println("YOU HAVE : "+words);

    }

    void OpponentWords() {
        System.out.println("Use one of your opponent's words and complete it with Common Pot");
    }
}
