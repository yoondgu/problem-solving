import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(bufferedReader.readLine());
        int line = 0;
        int end = 0;

        while (x > end) {
            line += 1;
            end += line;
        }

        int diff = end - x;
        int top = 0;
        int bottom = 0;
        if (line%2 == 0) {
            top = line - diff;
            bottom = 1 + diff;
        } else {
            top = 1 + diff;
            bottom = line - diff;
        }

        System.out.printf("%d/%d", top, bottom);
    }
}