import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = -1;
        for (int i = 0; i < N; i++) {
            List<Integer> plays = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> tricks = plays.subList(2, 7);
            Collections.sort(tricks, Collections.reverseOrder());
            int score = Math.max(plays.get(0), plays.get(1)) + tricks.get(0) + tricks.get(1);

            max = Math.max(max, score);
        }

        System.out.println(max);
    }
}
