package srcmain;

import java.util.*;

public class Player {
    private static final int MAX_NICKNAME_SIZE = 20;
    private static final int MAX_PLAYER_SIZE = 4;
    private static final int MAX_HAND_SIZE = 5;
    private Map<String, Integer> player = new HashMap<>();
    private String name;
    private int money = 10000;
    private List<Map.Entry<String, Integer>> player_list = new ArrayList<>(player.entrySet());

    Scanner sc = new Scanner(System.in);

    public void printPlayers() {
        player_list = new ArrayList<>(player.entrySet()); // 항상 최신화
        for (int i = 0; i < player_list.size(); i++) {
            Map.Entry<String, Integer> entry = player_list.get(i);
            System.out.println((i+1) + "번 플레이어 [닉네임: " + entry.getKey() + "] , [잔액: " + entry.getValue()+"]");
        }
    }

    public void addPlayer(int count) {
        int i = 0;
        String nickname;
        while (i < count) {
            System.out.print((i + 1) + "번째 플레이어의 닉네임을 입력해 주세요. :");
            nickname = sc.nextLine();
            if (nickname == null || nickname.trim().isEmpty()) {
                System.out.println("닉네임을 입력해 주세요.");
                continue;
            }
            if (nickname.length() > MAX_NICKNAME_SIZE) {
                System.out.println("닉네임은 " + MAX_NICKNAME_SIZE + "글자 이상 생성이 불가능 합니다.");
                continue;
            }

            if (player.containsKey(nickname)) {
                System.out.println("중복된 닉네임 입니다.");
                continue;
            }
                player.put(nickname, money);
                System.out.println(nickname + " 플레이어가 생성되었습니다.\t 잔액:" + money);
                i++;

        }
    }


    public int startPlayerSetting() {
        int count = 0;
        while (true) {
            try {
                System.out.print("생성할 플레이어 수를 입력해 주세요. (최대 " + MAX_PLAYER_SIZE + "명) :");
                count = Integer.parseInt(sc.nextLine());
                if (count >= 1 && count <= MAX_PLAYER_SIZE) {
                    System.out.println("플레이할 플레이어 수는"+count+"명입니다.");
                    break;
                }else {
                    System.out.println("잘못 입력하셨습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
            }

        }
        return count;
    }

}