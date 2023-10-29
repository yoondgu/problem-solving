import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 완주기록을 시간 객체로 변환한다.
        // list로 저장한다.
        // 시간 순으로 정렬한다.
        // 정렬한 선수를 for문으로 돌면서
        // 팀 별 순위 저장list<int>, 팀 별 점수 계산을 같이 한다.
        // 팀 별 점수가 같으면 최고 순위를 비교한다.

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            final StringTokenizer playerInfo = new StringTokenizer(br.readLine(), " ");
            players.add(new Player(playerInfo.nextToken(), playerInfo.nextToken()));
        }

        Collections.sort(players, Comparator.comparing(Player::getTime));

        Map<String, List<Player>> playersByTeam =  new HashMap<>();
        int[] scores = new int[2];
        int score = 8;
        for (Player player : players) {
            final String team = player.getTeam();
            final List<Player> finished = playersByTeam.getOrDefault(team, new ArrayList<>());
            finished.add(player);
            playersByTeam.put(team, finished);

            if ("B".equals(team)) {
                scores[0] += score;
            } else {
                scores[1] += score;
            }
            score--;
        }

        boolean isBlueWin = false;
        int blueScore = scores[0];
        int redScore = scores[1];
        if (blueScore == redScore) {
            for (int i = 0; i < 4; i++) {
                final Player blueTop = playersByTeam.get("B").get(i);
                final Player redTop = playersByTeam.get("R").get(i);
                if (blueTop.compareTo(redTop) == 0) {
                    continue;
                }
                if (blueTop.compareTo(redTop) < 0) {
                    isBlueWin = true;
                } else {
                    isBlueWin = false;
                }
                break;
            }
        } else {
            isBlueWin = blueScore > redScore;
        }

        if (isBlueWin) {
            System.out.println("Blue");
        } else {
            System.out.println("Red");
        }
    }

    static class Player implements Comparable<Player> {
        private final LocalTime time;
        private final String team;

        public Player(String time, String team) {
            this.time = parseTime(time);
            this.team = team;
        }

        private LocalTime parseTime(String time) {
            final String[] values = time.split(":");
            final int minutes = Integer.parseInt(values[0]);
            final int seconds = Integer.parseInt(values[1]);
            final int milliSeconds = Integer.parseInt(values[2]);
            return LocalTime.of(0, minutes, seconds, milliSeconds);
        }

        public LocalTime getTime() {
            return time;
        }

        public String getTeam() {
            return team;
        }



        @Override
        public String toString() {
            return "Player{" +
                    "time=" + time +
                    ", team='" + team + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Player o) {
            return time.compareTo(o.time);
        }
    }
}
