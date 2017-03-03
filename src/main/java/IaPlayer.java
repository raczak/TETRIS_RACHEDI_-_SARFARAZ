import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 */
public class IaPlayer extends Player{
    public int id = 2;
    public IaPlayer() {
        this.words = new ArrayList<String>();
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

        System.out.println("Verification of the word ...\n");
        String testedWord = createWord("");
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

    public String createWord(String word) {
        ArrayList<String> wordTested = new ArrayList<String>();
        for (int i = 0; i < potInstance.getLetterList().size(); i++) {
            wordTested.addAll(permutation(potInstance.getLetterList().get(i) + word));
        }
        for (int i = 0; i < wordTested.size(); i++) {
            try {
                if (potInstance.containsInDico(wordTested.get(i))) {
                    return wordTested.get(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static ArrayList<String> permutation(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            String last = s.substring(lastIndex);
            String rest = s.substring(0, lastIndex);
            res = merge(permutation(rest), last);
        }
        return res;
    }

    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        for (String s : list) {
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
}
