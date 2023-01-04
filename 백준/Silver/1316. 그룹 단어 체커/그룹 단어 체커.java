import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < num; i++) {
			String word = br.readLine();

			boolean isGroupWord = true;
			for (int j = 0; j < word.length(); j++) {
				String ch = String.valueOf(word.charAt(j));
				
				int countChar = word.length() - word.replaceAll(ch, "").length();
				if (countChar == 1) {
					continue;
				}
				
				if (countChar != word.length()) {
					isGroupWord = checkGroupChar(word, j, countChar);
					if (!isGroupWord) {
						break;
					}
				}
				
				j += countChar -1; 
			}
			
			if (isGroupWord) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean checkGroupChar(String word, int beginIndex, int countChar) {
		
		for (int i = beginIndex; i < beginIndex+countChar; i++) {
			if (word.charAt(beginIndex) != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
