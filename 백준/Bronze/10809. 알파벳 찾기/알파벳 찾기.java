import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word = br.readLine();
		br.close();
		
		char check = 97;
		
		for (int i = 0; i < 26; i++) {
			int result = word.indexOf(check + i);
			bw.write(String.valueOf(result));
			bw.write(" ");
		}
		
		bw.flush();
		bw.close();
	}
}
