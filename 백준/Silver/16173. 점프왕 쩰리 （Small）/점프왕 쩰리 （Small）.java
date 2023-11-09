import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean canArrive = false;

    public static void main(String[] args) throws IOException {
        // 정사각형 내에서 이동
        // 0,0 에서 출발, +1, +1 만 가능 (-는 없음)
        // 각 칸에 이동 가능 수가 쓰여있음
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                final String s = tk.nextToken();
                map[i][j] = Integer.parseInt(s);
            }
        }
        // DFS, 오른쪽 아니면 아래쪽으로 가고
        // 밖으로 떨어졌는지 확인
        // 승리 지점인지 확인 (-1)
        dfs(map, 0, 0);
        if (canArrive) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int[][] map, int x, int y) {
        if (x >= N || y >= N) {
            return;
        }
        if (x == N-1 && y == N-1 && map[x][y] == -1) {
            canArrive = true;
            return;
        }
        int current = map[x][y];
        if (current == 0) {
            return;
        }

        dfs(map, x + current, y);
        dfs(map, x, y + current);
    }
}
