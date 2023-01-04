import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int n = Integer.parseInt(input1[0]);
		int l = Integer.parseInt(input1[1]);
		String[] input2 = br.readLine().split(" ");
		
		boolean[] coord = new boolean[1001];
		for (String crd : input2) {
			coord[Integer.parseInt(crd)] = true;
		}
		
		int x = 0;
		int cnt = 0;
		while (x < 1001) {
			if (coord[x]) {
				x += l;
				cnt++;
			} else {
				x++;
			}
		}
		
		System.out.println(cnt);
	}
}
