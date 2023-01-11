import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int max = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int columnCount = 0;
            while (tokenizer.hasMoreTokens()) {
                columnCount++;
                int number = Integer.parseInt(tokenizer.nextToken());
                max = Math.max(max, number);
                if (max == number) {
                    row = i + 1;
                    column = columnCount;
                }
            }
        }

        System.out.println(max);
        System.out.println(String.join(" ", String.valueOf(row), String.valueOf(column)));
    }
}