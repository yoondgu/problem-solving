import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int paperCount = Integer.parseInt(bufferedReader.readLine());
        boolean[][] area = new boolean[100][100];

        for (int i = 0; i < paperCount; i++) {
            String[] points = bufferedReader.readLine().split(" ");
            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);
            for (int j = 0; j < 10; j++) {
                int row = y1+ j;
                IntStream.range(0, 10)
                        .forEach(column -> area[x1 + column][row] = true);
            }
        }

        int areaSize = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (area[i][j]) {
                    areaSize++;
                }
            }
        }

        System.out.println(areaSize);
    }
}