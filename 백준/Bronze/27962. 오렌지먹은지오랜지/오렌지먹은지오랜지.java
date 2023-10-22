import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(reader.readLine());
        final String word = reader.readLine();

        for (int i = 1; i <= N; i++) {
            // 맨 앞을 포함하는 부분 문자열
            final String forward = word.substring(0, i);
            // 맨 뒤를 포함하는 부분 문자열
            final String backward = word.substring(N - i, N);
            int equalsCount = 0;
            for (int j = 0; j < i; j++) {
                if (forward.charAt(j) == backward.charAt(j)) {
                    equalsCount++;
                }
            }
            if (equalsCount == i - 1) {
                System.out.print("YES");
                return;
            }
        }
        if (N == 2 && word.charAt(0) != word.charAt(1)) {
            System.out.print("YES");
            return;
        }
        System.out.print("NO");
    }

}
