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
        dfs(0);
    }

    // 1 2 3 4
    // 1 2 3
    // 1 2 4
    //
    public static void dfs(int depth) {
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
                numbers[depth] = i+1;
                // 숫자 1에서 너비 탐색 시작. visited에서 1 거르고 2,3,4에서 탐색.. -> 1, 2, 3, 4에서 반복
                // 1 2 - depth 1
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
