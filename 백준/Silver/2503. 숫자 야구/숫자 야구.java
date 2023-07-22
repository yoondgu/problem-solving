import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static int NUMBER_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> strikeCount = new HashMap<>();
        Map<String, Integer> ballCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String numbers = st.nextToken();
            strikeCount.put(numbers, Integer.parseInt(st.nextToken()));
            ballCount.put(numbers, Integer.parseInt(st.nextToken()));
        }

        int answerCount = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (j == k || i == k) {
                        continue;
                    }
                    String answers = i + "" + j + k;
                    if (isStrikeMatch(strikeCount, answers) && isBallMatch(ballCount, answers)) {
                        answerCount++;
                    }
                }
            }
        }

        System.out.println(answerCount);
    }

    private static boolean isStrikeMatch(Map<String, Integer> strikeCount, String answers) {
        for (Entry<String, Integer> entry : strikeCount.entrySet()) {
            if (countStrike(entry.getKey(), answers) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBallMatch(Map<String, Integer> ballCount, String answers) {
        for (Entry<String, Integer> entry : ballCount.entrySet()) {
            if (countBall(entry.getKey(), answers) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static int countStrike(String numbers, String answers) {
        return (int) IntStream.range(0, NUMBER_COUNT)
                .filter(index -> Objects.equals(numbers.charAt(index), answers.charAt(index)))
                        .count();
    }

    private static int countBall(String numbers, String answers) {
        return (int) IntStream.range(0, NUMBER_COUNT)
                .filter(index -> !Objects.equals(numbers.charAt(index), answers.charAt(index)) && answers.contains(String.valueOf(numbers.charAt(index))))
                .count();
    }

}