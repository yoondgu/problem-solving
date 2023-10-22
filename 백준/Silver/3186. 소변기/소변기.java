import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int goal = K-1;
        boolean status = false;

        final char[] chars = br.readLine().toCharArray();
        List<Integer> flush = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (status && chars[i] == '1') {
                goal = i + L;
            }
            if (!status && chars[i] == '0') {
                goal = i + K;
            }
            if (!status && i == goal) {
                status = true;
                goal += L;
            }
            if (status && i ==  goal) {
                status = false;
                goal += K;
                flush.add(i + 1);
            }
        }

        if (status) {
            flush.add(goal + 1);
        }

        StringBuilder sb = new StringBuilder();
        if (flush.isEmpty()) {
            sb.append("NIKAD").append("\n");
        } else {
            for (int i = 0; i < flush.size(); i++) {
                sb.append(flush.get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }
}

