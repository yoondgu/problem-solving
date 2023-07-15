import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long jw = Integer.parseInt(st.nextToken());
        int[] others = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            others[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(others);

        for (final int other : others) {
            if (jw < other) {
                System.out.println("No");
                return;
            }
            if (jw > other) {
                jw += other;
            }
        }

        for (final int other : others) {
            if (jw == other) {
                System.out.println("No");
                return;
            }
        }
        
        System.out.println("Yes");
    }
}