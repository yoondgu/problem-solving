import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        List<List<Integer>> points = new ArrayList<>();
        while (points.size() < N) {
            List<Integer> coords = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            points.add(coords);
        }

        points.sort(Comparator.comparingInt((List<Integer> o) -> o.get(0)).thenComparingInt(o -> o.get(1)));

        StringBuilder output = new StringBuilder();
        points.forEach(point -> output.append(point.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n"));
        System.out.println(output);
    }
}