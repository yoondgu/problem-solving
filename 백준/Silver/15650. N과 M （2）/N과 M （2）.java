import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String[] input = scanner.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N];
        numbers = new int[M];
        dfs(0, 0);
    }
    
    public static void dfs(int depth, int now) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (now < i+1) {
                    numbers[depth] = i+1;
                    dfs(depth+1, i+1);
                }
                visited[i] = false;
            }
        }
    }

}
