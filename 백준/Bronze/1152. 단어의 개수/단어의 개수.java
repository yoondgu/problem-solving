import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		if (line.isBlank()) {
			System.out.println(0);
			return;
		} else if (line.isEmpty()) {
			System.out.println(0);
			return;
		}
		
		line = line.trim();
		String[] words = line.split(" ");
		
		System.out.println(words.length);
	}
}
