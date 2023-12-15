import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int n;
    private static int k;
    private static int[] cards;
    private static boolean[] visited;
    private static Set<String> numbers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "");

        System.out.println(numbers.size());
    }

    private static void dfs(int depth, String number) {
        if (depth == k) {
            numbers.add(number);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, number + cards[i]);
                visited[i] = false;
            }
        }
    }
}
