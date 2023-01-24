import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            numbers.add(number);
            sum += number;
        }

        // 평균
        System.out.println((int) Math.round((sum * (1.0) / N)));

        // 중앙값
        Collections.sort(numbers);
        System.out.println(numbers.get(N/2));

        // 최빈값
        Map<Integer, Integer> numbersCount = new HashMap<>();
        numbers.forEach(number -> numbersCount.put(number, numbersCount.getOrDefault(number, 0) + 1));
        int maxFrequency = Collections.max(numbersCount.values());
        List<Integer> maxFrequencyNumbers = numbersCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        if (maxFrequencyNumbers.size() > 1) {
            System.out.println(maxFrequencyNumbers.get(1));
        } else {
            System.out.println(maxFrequencyNumbers.get(0));
        }

        // 범위
        System.out.println(Collections.max(numbers) - Collections.min(numbers));
    }
}