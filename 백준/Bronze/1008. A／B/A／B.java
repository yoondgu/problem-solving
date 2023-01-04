import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        if (0 < A && B < 10) {
            double result = A/(double)B;
        System.out.println(result);            
        }
    }
}