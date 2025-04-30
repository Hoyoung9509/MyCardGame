package srcmain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck extends Card{
        private static srcmain.CardDeck cd = new srcmain.CardDeck();
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

        public static srcmain.CardDeck getInstance(){
            return cd;
        }


    }

