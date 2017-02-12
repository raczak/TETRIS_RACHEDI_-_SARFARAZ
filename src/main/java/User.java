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

    void useMyWords() {
        System.out.println("Use one of your words and complete it with Common Pot");

        String words = " ";
        for (String item : this.words) {
            words += item;
        }
        System.out.println("Which word you wanna us ? : "+words);
        String wordSelected = this.sc.next();

        if (!this.words.contains(wordSelected)) {
            System.out.println("No ! It's not your word ");
            this.useMyWords();
        }
        else
        {
            System.out.println("Choose letter from Common Pot to finish your word :");
            String lettersSelected = sc.next();
        }
        //System.out.println("Ok try to build your word with : "+wordSelected);

        //Tant que le bug audessus persiste la partie ci dessous commenté ne doit pas être décommenté
        /*if(!potInstance.compareToCommonPot(lettersSelected)){
            System.out.println("No ! This letters are not in the Common Pot ");
            this.useMyWords();
        }
        String createdWord = wordSelected + lettersSelected;
        System.out.println("You choose : "+createdWord);

        try {
            potInstance.dicoAccess(createdWord);
            if(createdWord == ""){
                System.out.println("Looseeeer, your french word doesn't exist :(\n");
            }else {
                //We add the word to player's collection
                this.words.add(createdWord);
                System.out.println("Word : '" + createdWord + "' is correct ! You can pull another letter :D\n");
                this.wordSuccess(createdWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    void useOpponentWords() {
        System.out.println("Use one of your opponent's words and complete it with Common Pot");
    }
}
