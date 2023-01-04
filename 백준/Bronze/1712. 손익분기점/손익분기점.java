import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] strings = input.split(" ");
		
		int fixedExpense = Integer.parseInt(strings[0]);
		int varExpense = Integer.parseInt(strings[1]);
		int price = Integer.parseInt(strings[2]);
		
		int breakEvenPoint;
		
		// C*N > A + B*N
		// N(C-B) > A
		// N > A/(C-B)
		
		if (price <= varExpense) {
			breakEvenPoint = -1;
		} else {
			breakEvenPoint = (int) Math.floor((double)fixedExpense/(price-varExpense)) + 1;
		}
		
		System.out.println(breakEvenPoint);
	}
}
