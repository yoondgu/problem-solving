import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Integer> dolls = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        Queue<Integer> queue = new LinkedList<>(dolls);

        int count = 0;

        while (!queue.isEmpty()) {
            List<Integer> remains = new ArrayList<>();
            while (!queue.isEmpty()) {
                int now = queue.poll();
                final Integer next = queue.peek();
                if (Objects.equals(now, next)) {
                    remains.add(next);
                }
            }
            count++;
            queue.addAll(remains);
        }

        System.out.println(count);
    }
}