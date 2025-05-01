package srcmain;

import java.util.*;

public class GameController {
    public static void start(){

        CardDeck cd = CardDeck.getInstance();
        PlayerManager pm = new PlayerManager();
        Dealer dealer = new Dealer();
        List<Player> players = pm.getPlayers();

        pm.setupPlayers();
        System.out.println("=== Player List ===");
        pm.printPlayers();
        System.out.println("=== Player Hand List ===");
        dealer.dealCards(players);
        for (int i = 0; i < players.size();i++){
        System.out.println((i+1)+"번 플레이어 핸드 : "+players.get(i).getHand());
        }
        /*for (Card c : cd.card) {
            System.out.println(c);
        }*/

    }
}
