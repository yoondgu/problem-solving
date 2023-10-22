import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    // 4 ~ 12 km
    // 개인 성적 -> 팀 점수
    // 한 팀에 여섯 명
    // 팀의 자격을 갖추지 못했으면 점수 X (선수의 수 != 6)
    // 팀 점수는 상위 네 명의 주자의 점수의 합
    // 동점의 경우 다섯번째 주자가 가장 빨리 들어온 팀이 우승

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 팀 당 선수 인원, 랭크를 젖아한다.
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            Map<Integer, Integer> countsByTeam = new HashMap<>();
            int[] rank = new int[N];
            final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(tokenizer.nextToken());
                countsByTeam.put(team, countsByTeam.getOrDefault(team, 0) + 1);
                rank[j] = team;
            }

            // rank에 있는 팀이 6명 이상인 팀이면 해당 팀 주자 인원 수를 늘린다.
            // 주자 인원 수가 4명이 되기 전까지는 점수를 더해준다.

            Map<Integer, Integer> scoreByTeam = new HashMap<>();
            Map<Integer, Integer> temp = new HashMap<>();
            int[] fifthGoalIndex = new int[N];

            int score = 1;
            for (int team : rank) {
                if (countsByTeam.get(team) >= 6) {
                    temp.put(team, temp.getOrDefault(team, 0) + 1);
                    
                    if (temp.get(team) <= 4) {
                        scoreByTeam.put(team, scoreByTeam.getOrDefault(team, 0) + score);
                    }
                    if (temp.get(team) == 5) {
                        fifthGoalIndex[team] = score;
                    }
                    score++;
                }
            }

            final List<Integer> teams = new ArrayList<>(scoreByTeam.keySet());
            teams.sort((team1, team2) -> {
                    final Integer team1Score = scoreByTeam.get(team1);
                    final Integer team2Score = scoreByTeam.get(team2);

                    if (Objects.equals(team1Score, team2Score)) {
                        return fifthGoalIndex[team1] - fifthGoalIndex[team2];
                    }
                    return team1Score - team2Score;
            });

            System.out.println(teams.get(0));
        }
    }
}
