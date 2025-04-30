package srcmain;

import srcmain.PlayerInfo;

import java.util.*;

public class Player {
    private static final int MAX_PLAYERS = 4;
    private static final int MAX_NAME_LEN = 20;

    private final List<PlayerInfo> players = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public List<PlayerInfo> getPlayers() {
        return players;
    }

    public void setupPlayers() {
        int count = inputPlayerCount();

        Set<String> nicknames = new HashSet<>();
        for (int i = 0; i < count; ) {
            System.out.print((i + 1) + "번째 플레이어 닉네임 입력: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("닉네임을 입력해 주세요.");
                continue;
            }

            if (name.length() > MAX_NAME_LEN) {
                System.out.println("닉네임은 " + MAX_NAME_LEN + "자 이하여야 합니다.");
                continue;
            }

            if (nicknames.contains(name)) {
                System.out.println("중복된 닉네임입니다. 다른 닉네임을 입력해 주세요.");
                continue;
            }

            players.add(new PlayerInfo(name));
            nicknames.add(name);
            i++;
            System.out.println(name + " 플레이어가 생성되었습니다.");
        }
    }

    private int inputPlayerCount() {
        while (true) {
            try {
                System.out.print("플레이할 플레이어의 수를 입력해 주세요 : (1~" + MAX_PLAYERS + "): ");
                int count = Integer.parseInt(sc.nextLine());
                if (count >= 1 && count <= MAX_PLAYERS) {
                    System.out.println(count+"명의 플레이어가 게임을 시작합니다.");
                    return count;
                }else {
                    System.out.println("1 ~ 4 명의 플레이어만 플레이 가능합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }


    public void printPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + "번 " + players.get(i));
        }
    }
}
