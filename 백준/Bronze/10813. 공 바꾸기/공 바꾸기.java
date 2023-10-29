import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // N개의 바구니, 공을 M번 바꿈
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] bags = new int[N];
        for (int i = 0; i < N; i++) {
            bags[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer balls = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(balls.nextToken());
            int second = Integer.parseInt(balls.nextToken());
            int temp = bags[first-1];
            bags[first-1] = bags[second-1];
            bags[second-1] = temp;
        }

        for (int bag : bags) {
            System.out.print(bag + " ");
        }
    }
}
