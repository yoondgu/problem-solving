import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] quiz = new String[n];
		int[] scores = new int[n];
		
		for (int i = 0; i < n; i++) {
			quiz[i] = br.readLine();
			
			int count = 0;
			int score = 0;
			for (int j = 0; j < quiz[i].length(); j++) {
				if ('X' == quiz[i].charAt(j)) {
					count = 0;
					continue;
				} else {
					count++;
					score += count;
				}
			}
			scores[i] = score;
		}
		
		for (int score : scores) {
			System.out.println(score);
		}
	}
}
