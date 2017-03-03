import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by Momin on 03/03/2017.
 */
public class IaPlayerTest {
    IaPlayer iap = new IaPlayer();
    Player p = new Player() {
        @Override
        int round() {
            return 0;
        }
    };
    protected CommonPot potInstance = CommonPot.getInstance();

    @Test
    public void createWordTest(){
        potInstance.addLetter('l');
        potInstance.addLetter('o');
        potInstance.addLetter('u');
        potInstance.addLetter('p');
        potInstance.addLetter('e');
        String testedWord = iap.createWord("");
        assertNotNull(testedWord);
    }
}

