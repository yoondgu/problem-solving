import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = bufferedReader.readLine().split(" ");
        int winners = Integer.parseInt(inputs[1]);

        List<Integer> scores = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            scores.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        scores.sort(Collections.reverseOrder());
        System.out.println(scores.get(winners - 1));
    }
}