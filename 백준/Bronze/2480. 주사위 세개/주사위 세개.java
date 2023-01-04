import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        boolean rangeA = 1 <= A && A <= 6;
        boolean rangeB = 1 <= B && B <= 6;
        boolean rangeC = 1 <= C && C <= 6;
        
        if (rangeA && rangeB && rangeC) {
            int prize = 0;
            if (A == B && B == C) {
                prize = 10000 + A*1000;
            } else if (A == B || A == C) {
                prize = 1000 + A*100;
            } else if (B == C) {
                prize = 1000 + B*100;
            } else if (A > B && A > C) {
                prize = A*100;
            } else if (B > A && B > C) {
                prize = B*100;
            } else if (C > A && C > B) {
                prize = C*100;
            }
            System.out.println(prize);
        }
    }
}