/**
 * Created by zrachedi on 08/02/2017.
 */
public class Game {
    private CommonPot potInstance;
    private Player user;
    private Player IA;

    public Game() {
        this.potInstance = CommonPot.getInstance();
        /* I choose to instanciate my 2 players directly in the constructor game */
        this.user = new User();
        this.IA = new IaPlayer();

        /* Then I launch the game */
        this.gameCycle();
    }

    public void gameCycle() {
        Player player = this.firstRound();
        int idPlayer = player.round();
        while(user.words.size()<10 || IA.words.size()<10) {
            System.out.println("IA score : "+IA.words.size());
            System.out.println("User score : "+user.words.size());
            if (idPlayer == 2){
                user.setOpponentList(IA.words);
                idPlayer = user.round();
            }else {
                user.setOpponentList(user.words);
                idPlayer = IA.round();
            }
        }
        String letters = " ";
        for (String item : user.words) {
            letters += " " + item;
        }
        System.out.println(letters+"\n");
    }

    public Player firstRound() {
        System.out.println("First round Go !!\n");

        char p1Letter = this.user.pullLetterFromBag();
        potInstance.addLetter(p1Letter);

        char IALetter = this.IA.pullLetterFromBag();
        potInstance.addLetter(IALetter);

        Player winner = this.user;
        if(p1Letter > IALetter) {
            winner = this.IA;
        } else {
            winner = this.user;
        }
        return winner;
    }
}
