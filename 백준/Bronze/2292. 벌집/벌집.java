import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(1);
			return;
		}
		
		int min = 2;
		int max = 1;
		int count = 1;
		while(true) {
			min += 6*(count-1);
			max += 6*count;
			count++;
			if (min <= n && n <= max) {
				break;
			}
		}
		System.out.println(count);
	}
	
}