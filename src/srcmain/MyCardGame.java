package srcmain;

import java.util.ArrayList;
import java.util.List;

class CardDeck extends Card{
    private static CardDeck cd = new CardDeck();
    private final int CARD_NUM = 52;
    Card[] card = new Card[CARD_NUM];


    private CardDeck(){
        List<String> kinds = new ArrayList<>();
        kinds.add("HEART");
        kinds.add("DIAMOND");
        kinds.add("CLUB");
        kinds.add("SPADE");

        int i = 0;
        for (String kind : kinds){
            for (int number = 1; number <= 13; number++) {
                String num = String.valueOf(number);

                if (number == 11){
                    num = "J";
                }
                else if (number == 12){
                    num ="Q";
                }else if (number == 13){
                    num = "K";
                }
                card[i++] = new Card(kind, num);
            }
        }

    }

    public static CardDeck getInstance(){
        return cd;
    }


}

class Card{
    final String  NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    Card(String KIND,String NUMBER) {
        this.NUMBER = String.valueOf(NUMBER);
        this.KIND = KIND;
    }
    Card(){
        this("HEART","1");
    }

    @Override
    public String toString() {
        return "Card{" +
                "NUMBER=" + NUMBER +
                ", KIND='" + KIND + '\'' +
                '}';
    }
}
public class MyCardGame {
    public static void main(String[] args) {
        CardDeck cd = CardDeck.getInstance();

        for (Card c : cd.card) {
            System.out.println(c);
        }
    }
}
