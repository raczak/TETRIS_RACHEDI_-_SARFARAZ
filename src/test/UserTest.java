import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Momin on 03/03/2017.
 */
public class UserTest {
    private ArrayList<String> wordList = new ArrayList<String>();
    private ArrayList<Character> commonPot = new ArrayList<Character>();
    User u = new User();
    Player p = new Player() {
        @Override
        int round() {
            return 0;
        }
    };
    String word = "oasis";

    @Test
    public void testWord(){
        try {
            String testedWord = p.potInstance.compareToDico(word, false);
            if(testedWord == ""){
                System.out.println("Looseeeer, your french word doesn't exist :(\n");
            }else {
                assertEquals(testedWord, word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUseMyWord(){
        Boolean flag = true;
        wordList.add("toto");
        if (!this.wordList.contains(word)) {
            flag = false;
        }
        assertEquals(false, flag);
    }

    @Test
    public void useCommonPotLetters(){
        commonPot.add('a');
        commonPot.add('d');
        commonPot.add('u');
        commonPot.add('g');
        Character testedChar = 'g';
        Boolean flag = true;
        if (!this.commonPot.contains(testedChar)) {
            flag = false;
        }
        assertEquals(false, flag);
    }
}
