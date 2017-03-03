import org.junit.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ahmed on 03/03/2017.
 */
public class DictionnaryTest {
    Dictionary dico = new Dictionary();
    String testedWord = "oasis";
    BufferedReader br = dico.OpenFile();

    @Test
    public void testWordEquals() throws IOException{
        String currentLine;
        do {
            currentLine = br.readLine();
            if (currentLine.equals(testedWord) || currentLine.equals(null)) {
                br.close();
                assertEquals(testedWord, currentLine);
                return;
            }
        } while (br.ready());
    }

    @Test
    public void testWordContains() throws IOException{
        String currentLine;
        do {
            currentLine = br.readLine();
            if (currentLine.startsWith(testedWord)) {
                br.close();
                assertEquals(testedWord, currentLine);
                return;
            }
        } while (br.ready());
    }
}
