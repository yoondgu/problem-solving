import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < c; i++) {
			String[] str = br.readLine().split(" ");
			
			int[] test = new int[str.length];
			for (int j = 0; j < str.length; j++) {
				test[j] = Integer.parseInt(str[j]);
			}
			
			int st = test[0];
			int total = 0;
			for (int j = 1; j <= st; j++) {
				total += test[j];
			}
			
			double avg = total/st;
			int higherStudent = 0;
			for (int j = 1; j <= st; j++) {
				if (test[j] > avg) {
					higherStudent++;
				}
			}
			
			double rate = (double)higherStudent/st*100;
			String result = String.format("%.3f", rate);
			bw.write(result + "%");
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
