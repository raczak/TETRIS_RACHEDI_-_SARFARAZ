import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Momin on 01/03/2017.
 * Test class for CommonPot class
 */
public class CommonPotTest {
    private ArrayList<Character> letterList;
    @Before
    public void CommonPotHolderTest(){
        letterList = new ArrayList<Character>();
    }

    @Test
    public void testListExists(){
        assertNotNull(letterList);
    }

    @Test
    public void testAddLetter(){
        letterList.add('a');
        char result = letterList.get(0);
        assertEquals('a', result);
    }

    @Test
    public void testRemoveLetter(){
        letterList.add('a');
        letterList.remove(0);
        boolean result = letterList.isEmpty();
        assertTrue(result);
    }

    @Test
    public void testEqualsToCommonPot(){
        letterList.add('a');
        letterList.add('e');
        letterList.add('f');
        letterList.add('o');
        String testedWord = "afoe";
        ArrayList<Character> wordConvertedToChar = new ArrayList<Character>();
        for (char c : testedWord.toCharArray()) {
            wordConvertedToChar.add(c);
        }
        boolean flag = false;
        for (Character item : wordConvertedToChar) {
            System.out.println(letterList.contains(item));
            if (letterList.contains(item)) {
                flag = true;
                assertEquals(true, flag);
            }else {
                flag = false;
                assertEquals(true, flag);
            }
        }
    }
}
