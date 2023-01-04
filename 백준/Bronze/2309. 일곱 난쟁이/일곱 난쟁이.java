import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static boolean[] used = new boolean[9];
	static int[] heights = new int[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int h = Integer.parseInt(br.readLine());
			heights[i] = h;
			sum += h;
		}

		Arrays.sort(heights);
		solve(0, 0, sum);
		for (int i = 0; i < 9; i++) {
			if (!used[i]) {
				System.out.println(heights[i]);
			}
		}
	}
	
	static boolean solve(int pos, int cnt, int val) {
		if (cnt == 2 && val == 100) {
			return true;
		}
		if (val <= 100) {
			return false;
		}
		if (pos == 9) {
			return false;
		}
		
		for (int i = pos; i < 9; i++) {
			used[i] = true;
			if (solve(i + 1, cnt + 1, val - heights[i])) {
				return true;
			};
			used[i] = false;
		}
		
		return false;
	}
	
}