import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 1 ~ N번 사람이 돌아가며 손을 뻗는다.
    // 한 사이클이 지나가면 추가로 손을 더 뻗는다.
    // A는 N,M의 2차원 배열로 주어진다.
    // N, M, K
    // N개의 줄에 M개의 정수
    // 세로로 순서대로 지나감. 수를 계속 더함
    // 1번은 첫번째 줄, 2번은 두번째줄, 3번은 세번째줄...
    // K에 도달할 때까지. (K와 같거나 큰 수)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[][] rounds = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer round = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                rounds[i][j] = Integer.parseInt(round.nextToken());
            }
        }

        int[] dist = new int[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dist[j] += rounds[j][i];
                if (dist[j] >= K) {
                    System.out.println((j+1) + " " + (i+1));
                    return;
                }
            }
        }
    }
}
