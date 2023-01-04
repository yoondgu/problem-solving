import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int x = 0; x < t; x++) {			
			String[] str = br.readLine().split(" ");
			int repeat = Integer.parseInt(str[0]);
			String s = str[1];
			
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < repeat; j++) {
					bw.write(s.charAt(i));
				}
			}
			
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
