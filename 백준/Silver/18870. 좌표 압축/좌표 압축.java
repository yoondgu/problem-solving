import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] inputs = bufferedReader.readLine().split(" ");

        int[] origin = new int[N];
        int[] sorted = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int point : sorted) {
            if (!ranks.containsKey(point)) {
                ranks.put(point, rank);
                rank++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int point : origin) {
            result.append(ranks.get(point)).append(" ");
        }
        System.out.println(result);
    }
}