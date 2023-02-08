import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] dealerInput = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(dealerInput[0]);
        int M = Integer.parseInt(dealerInput[1]);

        int[] cards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                    for (int k = j+1; k < N; k++) {
                        sum = cards[i] + cards[j] + cards[k];
                        if (sum > max && sum <= M) {
                            max = sum;
                        }
                    }
            }
        }

        System.out.println(max);
    }
}