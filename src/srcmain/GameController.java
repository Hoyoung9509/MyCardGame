package srcmain;

public class GameController {
    public static void start(){

        CardDeck cd = CardDeck.getInstance();
        Player p = new Player();

        p.setupPlayers();
        /*for (Card c : cd.card) {
            System.out.println(c);
        }*/
        p.printPlayers();
    }
}
