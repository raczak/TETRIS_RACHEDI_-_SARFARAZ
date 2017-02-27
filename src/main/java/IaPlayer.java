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
        String testedWord = "";
        int prefix = 1;
        ArrayList<Integer> used_words = new ArrayList<Integer>();
        int initial_indice;

        for(int i=0; i< this.potInstance.getLetterList().size(); i++){
            used_words.add(i);
            initial_indice = i;
            testedWord = this.potInstance.getLetterList().get(i).toString();

            for(int j=0; j<this.potInstance.getLetterList().size(); j++){
                if(used_words.contains(j)){
                    break;
                } else {
                    used_words.add(j);
                    testedWord = testedWord + this.potInstance.getLetterList().get(j).toString();
                    try {
                        if(this.potInstance.containsInDico(testedWord) == false){
                            used_words.remove(j);
                            break;
                        } else {
                            if(this.potInstance.compareToDico(testedWord, false) == testedWord){
                                return testedWord;
                            } else {
                                prefix = prefix + 1;
                                j=-1;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



        String word = "";
        ArrayList<Integer> checked_position = new ArrayList<Integer>();
        int word_length = word.length();
        System.out.println("taille du pot commun : "+this.potInstance.getLetterList().size());
        for(int i = 0; i < this.potInstance.getLetterList().size(); i++)
        {
            System.out.println("i : "+i);
            System.out.println("Rajout de l'indice : "+i);
            checked_position.add(i);
            word = this.potInstance.getLetterList().get(i).toString();
            //System.out.println("lettre de départ = "+word);
            for(int j = 0; j < this.potInstance.getLetterList().size(); j++)
            {
                System.out.println("indice lettre complémentaire testée : "+j);
                if(checked_position.contains(j)){
                    if(j+1 < this.potInstance.getLetterList().size()){
                        System.out.println("valeur j : "+j);
                        //System.out.println("taille du pot commun : "+this.potInstance.getLetterList().size());
                        j++;
                        System.out.println("j+i : "+j);
                    }
                    if(j+1 == this.potInstance.getLetterList().size()){
                        System.out.println("j+1=longueur pot commun");
                        break;
                    }
                }
                String item = this.potInstance.getLetterList().get(j).toString();
                word=word+item;
                System.out.println("Combinaisons testées = "+word);
                try {
                    if(this.potInstance.containsInDico(word) == false){ //si le mot n'est pas contenu dans dictionnaire
                        System.out.println("mot non trouvé, valeur de j : "+j);
                        word=word.substring(0, word.length()-1);
                    } else {
                        System.out.println("mot contenu");
                        System.out.println("Rajout de l'indice : "+j);
                        checked_position.add(j);
                        j=0;
                        if(this.potInstance.compareToDico(word, false) == word){ //si le mot == dictionnaire
                            return word;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            checked_position.remove(i);
        }
        return "";
    }
}
