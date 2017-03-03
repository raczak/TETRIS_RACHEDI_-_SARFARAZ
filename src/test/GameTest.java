import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Momin on 03/03/2017.
 */
public class GameTest {
    User u = new User();
    ArrayList<Character> playerPot = new ArrayList<Character>();
    ArrayList<Character> IAPot = new ArrayList<Character>();
    ArrayList<String> wordList = new ArrayList<String>();

    @Test
    public void testFirstRound(){
        char playerLetter = 'o';
        playerPot.add(playerLetter);
        char IALetter = 'r';
        IAPot.add(IALetter);
        Boolean flag = true;
        flag = IALetter < playerLetter;
        assertEquals(false, flag);

    }

    @Test
    public void testGameEnd(){
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        Boolean flag = true;
        if(wordList.size() > 9){
            flag = false;
        }
        assertEquals(false, flag);
    }

    @Test
    public void testWordChain(){
        wordList.add("toto");
        wordList.add("toto");
        wordList.add("toto");
        String words = "";
        for (String item : wordList) {
            words += " " + item;
        }
        String expectedWords = " toto toto toto";
        assertEquals(expectedWords,words);
    }
}
