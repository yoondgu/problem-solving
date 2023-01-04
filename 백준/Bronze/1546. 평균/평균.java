import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] strs = br.readLine().split(" ");
		int[] scores = new int[n];
		int max = 0;
		
		for (int i=0; i < n; i++) {
			scores[i] = Integer.parseInt(strs[i]);
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		double total = 0; 
		for (int score : scores) {
			total += (score*100.0)/max;
		}
		
		System.out.println(total/n);
			
	}
}
