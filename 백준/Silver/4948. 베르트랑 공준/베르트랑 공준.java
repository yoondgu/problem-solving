import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }
            System.out.println(countPrimes(n));
        }
    }

    private static int countPrimes(int n) {
        int count = 0;
        for (int number = n + 1; number <= 2*n; number++) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
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