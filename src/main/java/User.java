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
        System.out.println("          --- Info --- \n");
        System.out.println("It is your turn !");
        potInstance.addLetter(this.pullLetterFromBag());
        potInstance.addLetter(this.pullLetterFromBag());
        potInstance.wordInCommonPot();
        this.mainMenu();

        return this.id;
    }

    void onlyCommonPotWords() {
        System.out.println("Try to build a word :");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        try {
            String testedWord = potInstance.compareToDico(word, true);
            if(testedWord == ""){
                System.out.println("Looseeeer, your french word doesn't exist :(\n");
            }else {
                //We add the word to player's collection
                this.words.add(testedWord);
                this.wordSuccess(testedWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void useMyWords() {
        System.out.println("Use one of your words and complete it with Common Pot");
        String words = " ";
        for (String item : this.words) {
            words += item+" ";
        }
        System.out.println("Which word you wanna use ? : "+words);
        String wordSelected = this.sc.next();

        if (!this.words.contains(wordSelected)) {
            System.out.println("No ! It's not your word ");
            this.useMyWords();
        } else {
            this.completeWordWithCommonPot(wordSelected);
        }
    }

    void useOpponentWords() {
        System.out.println("Use one of your opponent's words and complete it with Common Pot letter(s)");
        String words = " ";
        for (String item : this.getOpponentList()) {
            words += item;
            words += " ";
        }
        System.out.println("Which word you wanna use ? : "+words);
        String wordSelected = this.sc.next();

        if (!this.getOpponentList().contains(wordSelected)) {
            System.out.println("No ! It's not his word ");
            this.useOpponentWords();
        } else {
            this.completeWordWithCommonPot(wordSelected);
        }
    }

    public void mainMenu() {
        System.out.println("\n          --- Menu --- \n");
        System.out.println("1-      Create word with Common Pot letters only");
        System.out.println("2-      Create word with my words");
        System.out.println("3-      Create word with opponent's words");
        int choice = this.sc.nextInt();
        switch (choice) {
            case 1:
                this.onlyCommonPotWords();
                break;
            case 2:
                if (this.words.size()>0) {
                    this.useMyWords();
                }else {
                    System.out.println("You haven't word yet ");
                }
                break;
            case 3:
                this.useOpponentWords();
                break;
            default:
                this.onlyCommonPotWords();
        }
    }
    public void completeWordWithCommonPot(String wordSelected) {
        System.out.println("Choose letter from Common Pot to finish your word :");
        String lettersSelected = sc.next();
        if (potInstance.compareToCommonPot(lettersSelected) == true){
            System.out.println("Ok try to build your word with : "+wordSelected);
            try {
                String createdWord = wordSelected + lettersSelected;
                System.out.println("You choosed the word : "+createdWord);
                String result = potInstance.compareToDico(createdWord, false);
                if(result == ""){
                    System.out.println("Looseeeer, your french word doesn't exist :(\n");
                }else {
                    //We add the word to player's collection
                    this.words.add(result);
                    this.wordSuccess(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please, use Common Pot letter(s)");
            this.useMyWords();
        }
    }
}
