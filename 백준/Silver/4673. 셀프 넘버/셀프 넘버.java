import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static int calculate(int n) {
		int total = n;
		
		while (n != 0) {
			total += (n%10);
			n /= 10; 
		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		
		boolean[] isSelfNumberList = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			int result = calculate(i);
			if (result > 10000) {
				continue; 
			}
			isSelfNumberList[result] = true;
		}
				
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i < isSelfNumberList.length; i++) {
			if (!isSelfNumberList[i]) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
	
}
		
		
