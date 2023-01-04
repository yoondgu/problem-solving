import java.util.Scanner;

public class Main {

	public static int calculate(int number) {
		int a = (int)(number/10); 
		int b = number%10;
		
		int firstNumber = (number%10)*10;
		int secondNumber = 0; 
		if (a+b < 10) {
			secondNumber = a+b;
		} else if (a+b < 100) {
			secondNumber = (a+b)%10; 
		} else {
			secondNumber = (a+b)%100;
		}
        
		return firstNumber + secondNumber;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int startNum = number;
		int count = 1;
		
		while (calculate(number) != startNum) {
			number = calculate(number);
			count += 1;
		}
		
		System.out.println(count);
		sc.close();
	}
	
}