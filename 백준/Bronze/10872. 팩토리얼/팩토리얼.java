import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        System.out.println(getFactorial(N));
    }

    private static int getFactorial(int value) {
        if (value == 0) {
            return 1;
        }
        return value*getFactorial(--value);
    }
}