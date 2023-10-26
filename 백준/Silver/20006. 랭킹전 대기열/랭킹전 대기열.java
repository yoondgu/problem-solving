import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // 방을 생성한다.
    // 처음 입장한 플레이어의 레벨 기준으로 -10, +10까지 입장 가능하다.
    // 입장 가능한 방이 있으면 입장시킨다.
    // 입장 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.
    // 방의 정원이 모두 차면 게임을 시작

    // 게임 방을 생성한다. -> 게임 방 목록에 저장한다.
    // 게임 방 목록에서 생성된 순서로 다음 플레이어가 들어갈 수 있는지 확인한다.
    // 들어갈 수 있으면 방에 추가하고 다음 플레이어를 확인한다.
    // - 이 때, 플레이어의 레벨도 같이 저장한다.
    // 모든 방에 들어갈 수 없으면 해당 플레이어가 첫 입장인 방을 새로 넣는다.

    // 리스트 순서대로 방을 출력한다.
    // 이 때 방의 정원이 꽉 찼으면 Started, 아니면 Waiting을 출력한다.
    // 플레이어의 순서는 이름 사전 순으로 출력한다.
    static int affordable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] first = br.readLine().split(" ");
        int playerCount = Integer.parseInt(first[0]);
        affordable = Integer.parseInt(first[1]);

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            final Player player = new Player(br.readLine());
            boolean hasJoined = false;
            for (Room room : rooms) {
                if (room.canJoin(player)) {
                    room.join(player);
                    hasJoined = true;
                    break;
                }
            }
            if (!hasJoined) {
                rooms.add(new Room(player));
            }
        }

        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    static class Room {

        private final int level;
        private final List<Player> players = new ArrayList<>();

        public Room(Player first) {
            this.level = first.getLevel();
            this.players.add(first);
        }

        public boolean canJoin(Player player) {
            if (isStarted()) {
                return false;
            }
            return player.getLevel() >= level - 10 && player.getLevel() <= level + 10;
        }

        public void join(Player player) {
            players.add(player);
        }

        private boolean isStarted() {
            return players.size() >= affordable;
        }

        private String showPlayers() {
            return players.stream()
                    .sorted(Comparator.comparing(o -> o.name))
                    .map(Player::toString)
                    .collect(Collectors.joining("\n"));
        }

        @Override
        public String toString() {
            return (isStarted() ? "Started!" : "Waiting!") + "\n"
                    + showPlayers();
        }
    }

    static class Player {

        private final int level;
        private final String name;

        public Player(String info) {
            final String[] split = info.split(" ");
            this.level = Integer.parseInt(split[0]);
            this.name = split[1];
        }

        public int getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return level + " " + name;
        }
    }
}
