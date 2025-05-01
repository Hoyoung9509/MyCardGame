package srcmain;

import java.util.*;

public class Player {
    private String nickname;
    private int money = 10000;
    private List<Card> hand = new ArrayList<>();
    private int win = 0;
    private int lose = 0;


    public int getWin(){
        return win;
    }
    public int getLose(){
        return lose;
    }
    public void win(){
        this.win++;
    }
    public void lose(){
        this.lose++;
    }

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickname='" + nickname + '\'' +
                ", money=" + money +
                ", win=" + win +
                ", lose=" + lose +
                '}';
    }
}
