import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 토핑 개수를 받는다.
        // 토핑 목록을 받는다.
        // split해서 순회한다.
        // endsWith Cheese이고 길이가 Cheese보다 큰 것만 Set에 담는다.
        // set의 크기가 4개이면 yummy

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String Cheese = "Cheese";
        int N = Integer.parseInt(br.readLine());
        StringTokenizer all = new StringTokenizer(br.readLine(), " ");

        Set<String> cheeses = new HashSet<>();
        while (all.hasMoreTokens()) {
            final String word = all.nextToken().strip();
            if (word.endsWith(Cheese)) {
                cheeses.add(word);
            }
        }

        if (cheeses.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
