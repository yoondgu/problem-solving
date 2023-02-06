import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int prime = 2;
        // TODO while문 continue 없도록 코드 수정해보기
        while (N > 1) {
            if (N%prime != 0) {
                prime++;
                continue;
            }
            System.out.println(prime);
            N /= prime;
        }
    }
}