package srcmain;
import java.util.*;
public class Dealer {
    private final CardDeck deck;
    private final DeckRank ranker;

    public Dealer() {
        this.deck = CardDeck.getInstance();
        this.ranker = new DeckRank();
    }


    public void dealCards(List<Player> players) {
        deck.shuffle();
        for (Player player : players) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                hand.add(deck.drawCard());
            }
            player.setHand(hand);
        }
    }

    public void evaluateRound(List<Player> players) {
        DeckRank ranker = new DeckRank();
        Player winner = players.get(0);
        int maxScore = ranker.evaluate(winner.getHand());

        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            int score = ranker.evaluate(player.getHand());
            if (score > maxScore) {
                winner = player;
                maxScore = score;
            }
        }

        for (Player p : players) {
            if (p == winner) {
                p.win();
            } else {
                p.lose();
            }
        }


        for (Player p : players) {
            String rankName = ranker.getHandRankName(p.getHand());
            System.out.println(p.getNickname() + " : " + p.getHand() +"핸드 족보 : "+rankName+ (p == winner ? " ← 승자!" : ""));
        }
        System.out.println();
    }


}
