import java.text.Normalizer;
import java.util.regex.Pattern;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zrachedi on 09/02/2017.
 * I deceided to use a singleton in order to keep
 * a single instance of the common pot for everyone
 */
public class CommonPot {
    private ArrayList<Character> letterList;
    private Dictionary dico;
    private CommonPot() {
        this.letterList = new ArrayList<Character>();
        this.dico = new Dictionary();
    }

    /** Holder */
    private static class CommonPotHolder {
        /** Unique Instance pre-initialized */
        private final static CommonPot instance = new CommonPot();
    }

    public ArrayList<Character> getLetterList() {
        return letterList;
    }

    /** Access point for unique instance of the singleton */
    public static CommonPot getInstance() {
        return CommonPotHolder.instance;
    }

    public void addLetter(char word) {
        this.letterList.add(word);
    }

    public String compareToDico(String word, Boolean verification) throws IOException {
        String convertedWord = this.convertAccentLettersToEnglishLetters(word);
        if (verification == true) {
            boolean flag = compareToCommonPot(convertedWord);
            if (flag) {
                System.out.println("dico.isWord... : "+convertedWord);
                return dico.isWord(convertedWord);
            } else {
                return "";
            }
        } else {
            return dico.isWord(convertedWord);
        }
    }

    public boolean containsInDico(String word) throws IOException {
        String convertedWord = this.convertAccentLettersToEnglishLetters(word);
        return dico.containsWord(word);
    }

    public boolean compareToCommonPot(String word) {
        ArrayList<Character> wordConvertedToChar = new ArrayList<Character>();
        for (char c : word.toCharArray()) {
            wordConvertedToChar.add(c);
        }
        boolean flag = false;
        for (Character item : wordConvertedToChar) {
            System.out.println(this.getLetterList().contains(item));
            if (this.getLetterList().contains(item)) {
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }

    public String convertAccentLettersToEnglishLetters(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}
