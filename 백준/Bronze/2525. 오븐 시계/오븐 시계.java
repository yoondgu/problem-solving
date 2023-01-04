import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        boolean rangeA = 0 <= A && A <= 23;
        boolean rangeB = 0 <= B && B <= 59;
        boolean rangeC = 0 <= C && C <= 1000;
        
        if (rangeA && rangeB && rangeC) {
            int hour = 0;
            int minute = 0;
            if (C < 60){
                hour = A;
                minute = B + C;
            } else {
                hour = A + (C - C%60)/60;
                minute = B + C%60;
            }
            if (minute >= 60) {
                hour += (minute - minute%60)/60;
                minute = minute%60;
            }
            if (hour >= 24) {
                hour -= 24;
            }
            System.out.println(hour + " " + minute);
        }
    }
}
