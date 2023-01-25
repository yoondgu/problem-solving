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

        List<String> sortedDigits = number.chars()
                .map(num -> num - '0')
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join("", sortedDigits));
    }
}
