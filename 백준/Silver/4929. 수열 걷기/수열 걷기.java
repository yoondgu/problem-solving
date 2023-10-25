import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String upLine = "";
        while (true) {
            upLine = br.readLine();
            if ("0".equals(upLine)) {
                return;
            }

            final String upNumbers = upLine.substring(upLine.indexOf(" ")).strip();
            final List<Integer> up = Arrays.stream(upNumbers.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            final String downLines = br.readLine();
            final String downNumbers = downLines.substring(upLine.indexOf(" ")).strip();
            final List<Integer> down = Arrays.stream(downNumbers.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            final List<Integer> upSums = new ArrayList<>();
            int upSum = 0;
            for (int num : up) {
                upSum += num;
                if (down.contains(num)) {
                    upSums.add(upSum);
                    upSum = 0;
                }
            }
            upSums.add(upSum);

            final List<Integer> downSums = new ArrayList<>();
            int downSum = 0;
            for (int num : down) {
                downSum += num;
                if (up.contains(num)) {
                    downSums.add(downSum);
                    downSum = 0;
                }
            }
            downSums.add(downSum);

            int total = 0;
            for (int i = 0; i < upSums.size(); i++) {
                total += Math.max(upSums.get(i), downSums.get(i));
            }

            System.out.println(total);
        }
    }
}
