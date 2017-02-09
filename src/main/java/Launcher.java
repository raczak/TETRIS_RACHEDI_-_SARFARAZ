/**
 * Created by zrachedi on 08/02/2017.
 */
public class Game {
    private CommonPot potInstance;

    public Game() {
        this.potInstance = CommonPot.getInstance();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.firstRound();

        Player player1 = new Player();
        IaPlayer Ia = new IaPlayer();

        System.out.println("hello");
    }

    public void firstRound() {
        player1
        System.out.println("first round");
    }
}
