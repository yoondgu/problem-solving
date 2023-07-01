import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, numbersCount, max = 0;
    static int[] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer first = new StringTokenizer(br.readLine());
        N = Integer.parseInt(first.nextToken());
        numbersCount = Integer.parseInt(first.nextToken());
        numbers = new int[numbersCount];

        StringTokenizer second = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (second.hasMoreTokens()) {
            numbers[i] = Integer.parseInt(second.nextToken());
            i++;
        }
        Arrays.sort(numbers);

        findMax(0);
        System.out.println(max);
    }

    private static void findMax(int now) {
        if (N < now) {
            return;
        }
        if (max < now) {
            max = now;
        }
        for (int i = 0; i < numbersCount; i++) {
            findMax((now * 10) + numbers[i]);
        }
    }
}