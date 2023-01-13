import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(bufferedReader.readLine());
        int N = Integer.parseInt(bufferedReader.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int number = M; number < N + 1; number++) {
            if (isPrime(number)) {
                sum += number;
                min = Math.min(min, number);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int div = 3; div <= Math.sqrt(number); div+= 2) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;
    }
}