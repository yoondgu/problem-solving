import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String number = bufferedReader.readLine();

        List<Integer> digits = number.chars()
                .map(num -> num - '0')
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        for (int digit : digits) {
            stringBuilder.append(digit);
        }

        System.out.println(stringBuilder);
    }
}