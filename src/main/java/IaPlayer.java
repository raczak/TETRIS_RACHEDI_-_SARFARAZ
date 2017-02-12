import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 */
public class IaPlayer extends Player{
    public int id = 2;
    public IaPlayer() {
        this.words = new ArrayList<String>();
        this.words.add("a");
        this.words.add("aa");
        this.words.add("loup");
        this.words.add("loupe");
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
            System.out.println("Vérification du mot au commonpot\n");
            String testedWord = potInstance.compareToDico("chat", true);
            System.out.println("Résultat de la vérification '" + testedWord);
            if(testedWord == ""){
                System.out.println("IA was unable to build a word :(\n");
            }else {
                this.words.add(testedWord);
                System.out.println("Word : '" + testedWord + "' is correct ! IA has build a word :D");
                System.out.println("He pull another letter\n");
                this.wordSuccess(testedWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.id;
    }
}
