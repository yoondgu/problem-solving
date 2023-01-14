import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Integer> partition = findPartition(n);
            Collections.sort(partition);
            System.out.println(partition.get(0) + " " + partition.get(1));
        }
    }

    private static List<Integer> findPartition(int n) {
        List<Integer> partition = new ArrayList<>();
        int half = n/2;
        // 1/2한 값이 소수인 경우
        if (isPrime(half)) {
            partition.add(half);
            partition.add(half);
            return partition;
        }
        // 1/2한 값이 소수가 아닌 경우
        List<List<Integer>> candidates = new ArrayList<>();
        for (int number = 0; number <= 9973; number++) {
            if (isPrime(number) && isPrime(n - number)) {
                candidates.add(new ArrayList<>(List.of(number, (n - number))));
            }
        }

        // 파티션 중 차이가 가장 작은 것을 선택
        int previousDiff = Integer.MAX_VALUE;
        for (List<Integer> candidate : candidates) {
            int diff = Math.abs(candidate.get(0) - candidate.get(1));
            if (diff < previousDiff) {
                partition = candidate;
                previousDiff = diff;
            }
        }
        return partition;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int div = 3; div <= Math.sqrt(number); div+= 2) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;
    }
}