package srcmain;

public class Card {
    final String  NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    Card(String KIND,String NUMBER) {
        this.NUMBER = NUMBER;
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
