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
                    this.useMyWords();
                }else {
                    System.out.println("You haven't word yet ");
                }
                break;
            case 3:
                this.useOpponentWords();
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
            String testedWord = potInstance.compareToDico(word, true);
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

    void useMyWords() {
        System.out.println("Use one of your words and complete it with Common Pot");

        String words = " ";
        for (String item : this.words) {
            words += item;
            words += " ";
        }
        System.out.println("Which word you wanna use ? : "+words);
        String wordSelected = this.sc.next();

        if (!this.words.contains(wordSelected)) {
            System.out.println("No ! It's not your word ");
            this.useMyWords();
        }
        else
        {
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
                        System.out.println("Word : '" + result + "' is correct ! You can pull another letter :D\n");
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
                        System.out.println("Word : '" + result + "' is correct ! You can pull another letter :D\n");
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
}
