import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine().toUpperCase();
		
		Map<Character, Integer> wordMap = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			
			if (wordMap.get(ch) == null) {
				wordMap.put(ch, 1);
			} else {
				wordMap.put(ch, wordMap.get(ch) + 1);
			}
		}
		
		int max = 0;
		Character result = ' ';
		for (Character key : wordMap.keySet()) {
			if (wordMap.get(key) > max) {
				max = wordMap.get(key);
				result = key;
			} else if (wordMap.get(key) == max) {
				result = '?';
			}
		}
		
		System.out.println(result);
	}
}
