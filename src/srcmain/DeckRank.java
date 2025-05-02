package srcmain;

import java.util.*;

public class DeckRank {
    private static final Map<String, Integer> CARD_VALUES = new HashMap<String, Integer>();
    static {
        CARD_VALUES.put("2", 2); CARD_VALUES.put("3", 3); CARD_VALUES.put("4", 4);
        CARD_VALUES.put("5", 5); CARD_VALUES.put("6", 6); CARD_VALUES.put("7", 7);
        CARD_VALUES.put("8", 8); CARD_VALUES.put("9", 9); CARD_VALUES.put("10", 10);
        CARD_VALUES.put("J", 11); CARD_VALUES.put("Q", 12); CARD_VALUES.put("K", 13);
        CARD_VALUES.put("A", 14);
    }
    public String getHandRankName(List<Card> hand) {
        if (isRoyalStraightFlush(hand)) return "로열 스트레이트 플러시";
        if (isStraightFlush(hand)) return "스트레이트 플러시";
        if (isFourOfAKind(hand)) return "포카드";
        if (isFullHouse(hand)) return "풀 하우스";
        if (isFlush(hand)) return "플러시";
        if (isStraight(hand)) return "스트레이트";
        if (isThreeOfAKind(hand)) return "트리플";
        if (isTwoPair(hand)) return "투 페어";
        if (isOnePair(hand)) return "원 페어";
        return "하이 카드";
    }

    public int evaluate(List<Card> hand) {
        if (isRoyalStraightFlush(hand)) return 100;
        if (isStraightFlush(hand)) return 90;
        if (isFourOfAKind(hand)) return 80;
        if (isFullHouse(hand)) return 70;
        if (isFlush(hand)) return 60;
        if (isStraight(hand)) return 50;
        if (isThreeOfAKind(hand)) return 40;
        if (isTwoPair(hand)) return 30;
        if (isOnePair(hand)) return 20;
        return 10;
    }

    private List<Integer> getSortedNumbers(List<Card> hand) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (Card card : hand) {
            numbers.add(CARD_VALUES.get(card.NUMBER));
        }
        Collections.sort(numbers);
        return numbers;
    }

    private boolean isFlush(List<Card> hand) {
        String kind = hand.get(0).KIND;
        for (Card c : hand) {
            if (!c.KIND.equals(kind)) return false;
        }
        return true;
    }

    private boolean isStraight(List<Card> hand) {
        List<Integer> numbers = getSortedNumbers(hand);
        boolean straight = true;
        for (int i = 0; i < 4; i++) {
            if (numbers.get(i) + 1 != numbers.get(i + 1)) {
                straight = false;
                break;
            }
        }

        if (straight) return true;

        // A-2-3-4-5 처리
        if (numbers.contains(14)) {
            List<Integer> lowAce = new ArrayList<Integer>();
            for (int n : numbers) {
                if (n == 14) lowAce.add(1);
                else lowAce.add(n);
            }
            Collections.sort(lowAce);
            boolean lowStraight = true;
            for (int i = 0; i < 4; i++) {
                if (lowAce.get(i) + 1 != lowAce.get(i + 1)) {
                    lowStraight = false;
                    break;
                }
            }
            return lowStraight;
        }

        return false;
    }

    private boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    private boolean isRoyalStraightFlush(List<Card> hand) {
        if (!isFlush(hand)) return false;

        List<Integer> numbers = getSortedNumbers(hand);
        int[] royal = {10, 11, 12, 13, 14};
        for (int i = 0; i < 5; i++) {
            if (numbers.get(i) != royal[i]) return false;
        }
        return true;
    }

    private Map<Integer, Integer> getFrequencyMap(List<Card> hand) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (Card c : hand) {
            int num = CARD_VALUES.get(c.NUMBER);
            if (!freq.containsKey(num)) freq.put(num, 1);
            else freq.put(num, freq.get(num) + 1);
        }
        return freq;
    }

    private boolean isFourOfAKind(List<Card> hand) {
        Map<Integer, Integer> freq = getFrequencyMap(hand);
        for (int count : freq.values()) {
            if (count == 4) return true;
        }
        return false;
    }

    private boolean isFullHouse(List<Card> hand) {
        Map<Integer, Integer> freq = getFrequencyMap(hand);
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : freq.values()) {
            if (count == 3) hasThree = true;
            else if (count == 2) hasTwo = true;
        }
        return hasThree && hasTwo;
    }

    private boolean isThreeOfAKind(List<Card> hand) {
        Map<Integer, Integer> freq = getFrequencyMap(hand);
        for (int count : freq.values()) {
            if (count == 3) return true;
        }
        return false;
    }

    private boolean isTwoPair(List<Card> hand) {
        Map<Integer, Integer> freq = getFrequencyMap(hand);
        int pairCount = 0;
        for (int count : freq.values()) {
            if (count == 2) pairCount++;
        }
        return pairCount == 2;
    }

    private boolean isOnePair(List<Card> hand) {
        Map<Integer, Integer> freq = getFrequencyMap(hand);
        int pairCount = 0;
        for (int count : freq.values()) {
            if (count == 2) pairCount++;
        }
        return pairCount == 1;
    }
}
