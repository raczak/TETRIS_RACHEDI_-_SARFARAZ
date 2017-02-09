/**
 * Created by zrachedi on 08/02/2017.
 */
public class Launcher {
    private CommonPot potInstance;

    public Launcher() {
        this.potInstance = CommonPot.getInstance();
    }

    public static void main(String[] args) {
        System.out.println("***WELCOME IN LETTER GAME !***\n");
        Game game = new Game();
    }
}
