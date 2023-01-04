import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        
        int westernYear = y - 543;
        
        if (1000 <= y && y <= 3000){
            System.out.println(westernYear);
        }

    }
}