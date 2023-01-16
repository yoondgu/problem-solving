import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        int maxCount = N/5;
        if (N%5 == 0) {
            System.out.println(maxCount);
            return;
        }

        int answer = Integer.MAX_VALUE;
        for (int count = 0; count <= maxCount; count++) {
            int remaining = N - count*5;
            if (remaining%3 != 0) {
                continue;
            }
            answer = Math.min(answer, (remaining/3) + count);
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }
}