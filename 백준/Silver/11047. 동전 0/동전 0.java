import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		Integer[] values = new Integer[n];
		for (int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(values, Collections.reverseOrder());
		int totalCnt = 0;
		int amount = k;
		for (int value : values) {
			if (amount == 0) {
				break;
			}
			
			if (value > amount) {
				continue;
			} else {
				int cnt = (int) Math.floor(amount/value);
				totalCnt += cnt;
				amount -= cnt*value;
			}
		}
		
		System.out.println(totalCnt);
	}
	
}
