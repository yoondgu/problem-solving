import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        System.out.println(getFibonacci(N));
    }

    private static int getFibonacci(int order) {
        if (order == 0) {
            return 0;
        }
        if (order == 1) {
            return 1;
        }
        return getFibonacci(order - 2) + getFibonacci(order - 1);
    }
}