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

        System.out.println("Vérification du mot au commonpot\n");
        String testedWord = createWord();
            /*String testedWord = potInstance.compareToDico("chat", true);
            System.out.println("Résultat de la vérification '" + testedWord);*/
        if(testedWord == ""){
            System.out.println("IA was unable to build a word :(\n");
        }else {
            this.words.add(testedWord);
            System.out.println("Word : '" + testedWord + "' is correct ! IA has build a word :D");
            System.out.println("He pull another letter\n");
            this.wordSuccess(testedWord);
        }
        return this.id;
    }

    public String createWord() {
        String word = "";
        for(int i = 0; i < this.potInstance.getLetterList().size(); i++)
        {
            System.out.println("i : "+i);
            word = word + this.potInstance.getLetterList().get(i).toString();
            System.out.println("iWord = "+word);
            for(int j = 0; j < this.potInstance.getLetterList().size(); j++)
            {
                System.out.println("j : "+j);
                if(i==j){
                    if(j+1 < this.potInstance.getLetterList().size()){
                        System.out.println("j : "+j);
                        System.out.println("size : "+this.potInstance.getLetterList().size());
                        j++;
                        System.out.println("j+i : "+j);
                    }
                }
                String item = this.potInstance.getLetterList().get(j).toString();
                String testedWord=word+item;
                System.out.println("jWord = "+testedWord);
                try {
                    if(this.potInstance.compareToDico(testedWord, false) == ""){
                        System.out.println("mot non trouvé, valeur de j : "+j);
                    } else {
                        return testedWord;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(i+1==this.potInstance.getLetterList().size()){
                i=word.length();
                word = word + this.potInstance.getLetterList().get(i).toString();
            } else {
                word = "";
            }
        }
        return "";
    }
}
