import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        while (numbers.size() < 5) {
            int number = Integer.parseInt(bufferedReader.readLine());
            numbers.add(number);
            sum += number;
        }

        Collections.sort(numbers);
        System.out.println(sum/5);
        System.out.println(numbers.get(2));
    }
}