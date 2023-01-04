import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static boolean checkNumber(int number) {		
		if (number < 100) {
			return true;
			
		} else if (number < 1000) {
			int a = number / 100;
			int b = (number/10) % 10;
			int c = number % 10;
			
			return (a-b == b-c);
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int initialNum = Integer.parseInt(str);
		
		int count = 0;
		for (int i = 1; i < initialNum+1; i++) {
			if (checkNumber(i)) {
				count++;
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
