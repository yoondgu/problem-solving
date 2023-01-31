import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = bufferedReader.readLine();
            if (!words.contains(word)) {
                words.add(word);
            }
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder output = new StringBuilder();
        words.forEach(word -> output.append(word).append("\n"));
        System.out.println(output);
    }
}