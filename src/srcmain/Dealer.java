package srcmain;
import java.util.*;
public class Dealer {
    private final CardDeck deck;
    private final DeckRank ranker;

    public Dealer() {
        this.deck = CardDeck.getInstance();
        this.ranker = new DeckRank();
    }


    public void dealCards(List<PlayerInfo> players) {
        deck.shuffle();
        for (PlayerInfo player : players) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                hand.add(deck.drawCard());
            }
            player.setHand(hand);
        }
    }




}
