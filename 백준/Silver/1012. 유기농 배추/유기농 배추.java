import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] baechus;
    static int M;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(tk.nextToken());
            N = Integer.parseInt(tk.nextToken());
            int K = Integer.parseInt(tk.nextToken());

            baechus =  new boolean[M][N];
            for (int j = 0; j < K; j++) {
                StringTokenizer pos = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(pos.nextToken());
                int y = Integer.parseInt(pos.nextToken());
                baechus[x][y] = true;
            }

            int count = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (baechus[j][k]) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }

        if (baechus[x][y]) {
            baechus[x][y] = false;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
        }
    }

}
