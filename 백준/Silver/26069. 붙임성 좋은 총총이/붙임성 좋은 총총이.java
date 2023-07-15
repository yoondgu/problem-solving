import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = N;
        Map<String, Boolean> metChong = new HashMap<>();
        metChong.put("ChongChong", true);
        while (count > 0) {
            count--;
            final String[] names = br.readLine().split(" ");
            if (metChong.getOrDefault(names[0], false)) {
                metChong.put(names[1], true);
            } else if (metChong.getOrDefault(names[1], false)) {
                metChong.put(names[0], true);
            }

        }

        System.out.println(metChong.values()
                .stream()
                .filter(value -> value).count());
    }
}