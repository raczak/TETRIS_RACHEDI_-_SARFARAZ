import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zrachedi on 09/02/2017.
 */
public abstract class Player {
    protected ArrayList<String> words;
    protected CommonPot potInstance = CommonPot.getInstance();
    protected Scanner sc = new Scanner(System.in);
    protected ArrayList<String> listOfOpponentWords;

    protected char pullLetterFromBag() {
        Random rand = new Random();
        char randLetter = (char)(rand.nextInt(26) + 'a');
        return randLetter;
    }
    abstract int round();

    void setOpponentList(ArrayList<String> oppenentList){
        this.listOfOpponentWords = oppenentList;
    }

    ArrayList<String> getOpponentList(){
        return this.listOfOpponentWords;
    }

    void wordSuccess(String testedWord) {
        System.out.println("SUCCESS : '" + testedWord + "' is correct ! You can pull another letter :D");
        ArrayList<Character> wordConvertedToChar = new ArrayList<Character>();
        for (char c : testedWord.toCharArray()) {
            wordConvertedToChar.add(c);
        }
        for (Character item : wordConvertedToChar) {
            if (potInstance.getLetterList().contains(item)) {
                potInstance.getLetterList().remove(item);
            }
        }
        potInstance.wordInCommonPot();
        potInstance.addLetter(this.pullLetterFromBag());
        //Because he found a word, he can try again
        if(this.words.size() < 10){
            this.round();
        } else {
            return;
        }
    }
}
