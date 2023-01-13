import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] givens = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(givens[0]);
        int N = Integer.parseInt(givens[1]);

        for (int number = M; number < N + 1; number++) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
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