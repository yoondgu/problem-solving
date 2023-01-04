import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int num = 1; num <= T; num++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result = A + B;
            System.out.println(result);
        }
    }
}