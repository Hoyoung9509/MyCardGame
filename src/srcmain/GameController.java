package srcmain;

public class GameController {
    public static void start(){
        int count = 0;
        CardDeck cd = CardDeck.getInstance();
        Player p = new Player();
        count = p.startPlayerSetting();
        p.addPlayer(count);
        /*for (Card c : cd.card) {
            System.out.println(c);
        }*/

        p.printPlayers();
    }
}
