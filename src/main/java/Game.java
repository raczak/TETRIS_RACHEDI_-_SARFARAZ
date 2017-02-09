/**
 * Created by zrachedi on 08/02/2017.
 */
public class Game {
    private CommonPot potInstance;
    private User user1;
    private IaPlayer IA;

    public Game() {
        this.potInstance = CommonPot.getInstance();
        /* I choose to instanciate my 2 players directly in the constructor game */
        this.user1 = new User();
        this.IA = new IaPlayer();

        /* Then I launch the game */
        this.gameLife();
    }

    public void gameLife() {
        int bigin = this.firstRound();

        if(bigin == 0) {
            System.out.println("It is your turn !");
            this.user1.round();
            String letters = " ";
            for (char item : potInstance.getLetterList()) {
                letters += " " + new StringBuilder().append(item).toString();
            }
            System.out.println("Letters in common pot : "+letters);
        }else {
            System.out.println("It's IA's turn !");
            String letters = " ";
            for (char item : potInstance.getLetterList()) {
                letters += " " + new StringBuilder().append(item).toString();
            }
            System.out.println("Letters in common pot : "+letters);
        }
    }

    public int firstRound() {
        System.out.println("First round Go !!\n");

        int begin = 1;
        char p1Letter = this.user1.pullLetterFromBag();
        potInstance.addLetter(p1Letter);
        char IALetter = this.IA.pullLetterFromBag();
        potInstance.addLetter(IALetter);

        if(p1Letter > IALetter) {
            begin = 0;
        }else {
            begin= 1;
        }
        return begin;
    }
}
