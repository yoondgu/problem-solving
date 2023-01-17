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
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < N) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        Collections.sort(numbers);
        for (int number : numbers) {
            stringBuilder.append(number).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}