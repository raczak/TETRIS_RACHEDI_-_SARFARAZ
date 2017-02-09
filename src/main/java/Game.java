/**
 * Created by zrachedi on 08/02/2017.
 */
public class Game {
    private CommonPot potInstance;
    private Player player1;
    private IaPlayer IA;

    public Game() {
        this.potInstance = CommonPot.getInstance();
        /* I choose to instanciate my 2 players directly in the constructor game */
        this.player1 = new Player();
        this.IA = new IaPlayer();

        /* Then I launch the game */
        this.gameLife();
    }

    public void gameLife() {
        this.firstRound();


        System.out.println("hello");
    }

    public void firstRound() {
        this.player1.pullLetterFromBag();
        this.IA.pullLetterFromBag();

        System.out.println("first round");
    }
}
