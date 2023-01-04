import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        if (1 <= n && n <= 10000){
            for (int num = 1; num <= n; num++) {
                total += num;
            }
        System.out.println(total);
        }
    }
}