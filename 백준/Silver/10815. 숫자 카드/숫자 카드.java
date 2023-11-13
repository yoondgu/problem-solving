import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final List<Integer> cards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int M = Integer.parseInt(br.readLine());
        final List<Integer> toFinds = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int target : toFinds) {
            if (find(cards, target)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    static boolean find(List<Integer> cards, int target) {
        if (cards.isEmpty()) {
            return false;
        }
        final int cardsSize = cards.size();
        final int mid = cardsSize/2;
        final int midValue = cards.get(mid);

        if (mid == 0 & midValue != target) {
            return false;
        }
        if (midValue == target) {
            return true;
        } else if (midValue < target) {
            return find(cards.subList(mid, cardsSize), target);
        } else {
            return find(cards.subList(0, mid), target);
        }
    }
}
