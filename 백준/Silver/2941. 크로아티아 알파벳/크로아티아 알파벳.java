import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String[] croAls = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		int croTotal = 0;
		int stringCroTotal = 0;
		for (int i = 0; i < croAls.length; i++) {
			int stringCnt = 0;
			if ("z=".equals(croAls[i])) {
				String newWord = word.replaceAll("dz=", "");
				stringCnt = newWord.length() - newWord.replaceAll("z=", "").length();
			} else {
				stringCnt = word.length() - word.replaceAll(croAls[i], "").length(); 
			}
			stringCroTotal += stringCnt; 
			croTotal += stringCnt/croAls[i].length();
		}
		
		int numTotal = word.length() - stringCroTotal;
		int total = croTotal + numTotal;
		
		System.out.println(total);
	}
}
