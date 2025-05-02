package srcmain;

import java.util.*;

public class GameController {
    public static void start() {
        PlayerManager pm = new PlayerManager();
        pm.setupPlayers();
        List<Player> players = pm.getPlayers();

        Dealer dealer = new Dealer();

        for (int i = 1; i <= 100; i++) {
            System.out.println("===== " + i + "번째 게임 =====");
            dealer.dealCards(players);
            dealer.evaluateRound(players);
        }


        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getWin() < players.get(j).getWin()) {
                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }

        System.out.println("===== 최종 결과 (승 수 내림차순) =====");
        for (Player p : players) {
            System.out.println(p);
        }
    }
}
