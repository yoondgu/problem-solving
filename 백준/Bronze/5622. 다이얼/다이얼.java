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
		
		int time = 0; 
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if (ch <= 67) {
				time += 3;
			} else if (ch <= 70) {
				time += 4;
			} else if (ch <= 73) {
				time += 5;
			} else if (ch <= 76) {
				time += 6;
			} else if (ch <= 79) {
				time += 7;
			} else if (ch <= 83) {
				time += 8;
			} else if (ch <= 86) {
				time += 9;
			} else if (ch <= 90) {
				time += 10;
			} 
		}
		
		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
		br.close();
	}
}
