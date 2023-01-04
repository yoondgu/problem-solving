import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int hour;
        int minute;
        
        if (0 <= H && H <= 23 && 0 <= M && M <= 59){
           if (H == 0 && M < 45) {
                hour = 23;
                minute = 15 + M;
                System.out.println(hour + " " + minute);

            } 
            if (H != 0 && M < 45){
                hour = H - 1;
                minute = 15 + M;
                System.out.println(hour + " " + minute);
            }
            if (M >= 45) {
                hour = H;
                minute = M - 45;
                System.out.println(hour + " " + minute);
            }
        }
        
    }
}