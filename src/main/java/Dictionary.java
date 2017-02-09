/**
 * Created by zrachedi on 09/02/2017.
 */

import fr.esiea.unique.binome.name.dictionary.IDictionary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dictionary implements IDictionary {

    public BufferedReader OpenFile() {
        String file = "src/main/resources/dico.txt";

        BufferedReader br = null;
        try {
            InputStream ips = new FileInputStream(file);
            InputStreamReader ipsr = new InputStreamReader(ips);
            br = new BufferedReader(ipsr);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return br;
    }

    public String isWord(String word) throws IOException {
        BufferedReader br = this.OpenFile();
        String currentLine;
        do {
            currentLine = br.readLine();
            if (currentLine.equals(word) || currentLine.equals(null)) {
                System.out.println("Word : '" + currentLine + "' is correct ! You can pull another letter :D\n");
                br.close();
                return currentLine;
            }
        } while (br.ready());
        System.out.println("Looseeeer, your french word doesn't exist :(\n");
        return "";
    }
}
