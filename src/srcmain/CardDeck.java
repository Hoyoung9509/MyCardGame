package srcmain;

import java.util.*;

public class CardDeck extends Card{
        private static CardDeck cd = new CardDeck();
        private final int CARD_NUM = 52;
        private int currentIndex = 0;
        Card[] card = new Card[CARD_NUM];


        private CardDeck(){
            List<String> kinds = new ArrayList<>();
            kinds.add("HEART");
            kinds.add("DIAMOND");
            kinds.add("CLUB");
            kinds.add("SPADE");

            int i = 0;
            for (String kind : kinds){
                for (int number = 2; number <= 14; number++) {
                    String num = String.valueOf(number);

                    if (number == 11){
                        num = "J";
                    }
                    else if (number == 12){
                        num ="Q";
                    }else if (number == 13){
                        num = "K";
                    }else if (number == 14){
                        num = "A";
                    }
                    card[i++] = new Card(kind, num);
                }
            }

        }

    public void shuffle() {
        List<Card> list = Arrays.asList(card);
        Collections.shuffle(list);
        card = list.toArray(new Card[0]);
        currentIndex = 0;
    }



    public Card drawCard() {
        if (currentIndex >= card.length) {
            throw new IllegalStateException("카드가 부족합니다.");
        }
        return card[currentIndex++];
    }

        public static CardDeck getInstance(){
            return cd;
        }


    }

