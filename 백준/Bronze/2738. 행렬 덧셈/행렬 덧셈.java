import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String sizeLine = bufferedReader.readLine();
        String[] sizes = sizeLine.split(" ");
        int N = Integer.parseInt(sizes[0]);
        int M = Integer.parseInt(sizes[1]);

        int[][] matrixA = makeMatrix(N, M);
        int[][] matrixB = makeMatrix(N, M);

        for (int i = 0; i < N; i++) {
            StringJoiner joiner = new StringJoiner(" ");
            for (int j = 0; j < M; j++) {
                joiner.add(String.valueOf(matrixA[i][j] + matrixB[i][j]));
            }
            System.out.println(joiner);
        }
    }

    private static int[][] makeMatrix(int rowSize, int columnSize) throws IOException {
        int[][] matrix = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            int rowIndex = i;
            String[] cells = bufferedReader.readLine().split(" ");
            IntStream.range(0, columnSize)
                    .forEach(columnIndex -> matrix[rowIndex][columnIndex] = Integer.parseInt(cells[columnIndex]));
        }
        return matrix;
    }
}