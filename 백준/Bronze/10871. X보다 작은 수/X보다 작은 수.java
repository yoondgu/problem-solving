import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nx = (br.readLine()).split(" ");
		int x = Integer.parseInt(nx[1]);
		
		String str=br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		br.close();
		
		while (stk.hasMoreTokens()) {
			int number = Integer.parseInt(stk.nextToken());
			if (number < x) {
				bw.write(number + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}
