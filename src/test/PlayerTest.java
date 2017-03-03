import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by ahmed on 03/03/2017.
 */
public class PlayerTest {
    protected ArrayList<String> words;
    protected CommonPot potInstance = CommonPot.getInstance();
    protected ArrayList<String> listOfOpponentWords;
    Player player = new Player() {
        @Override
        int round() {
            return 0;
        }
    };

    @Test
    public void testPull(){
        assertNotNull(player.pullLetterFromBag());
    }

    @Test
    public void testSetOpponentList(){
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("toto");
        this.listOfOpponentWords = wordList;
        assertNotNull(this.listOfOpponentWords);
    }


}
