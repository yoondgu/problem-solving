import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			String[] numbers = str.split(" ");
			int result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
			
			if (result == 0) {
				return;
			}
			
			System.out.println(result);
		}
		
	}
}
