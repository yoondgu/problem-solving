import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static String printForm(int i, int a, int b) {
		String result = "Case #" + i + ": " + a + " + " + b + " = " + (a+b);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=1; i <=t; i++) {
			String numString = br.readLine();
			String[] numbers = numString.split(" ");
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			String result = printForm(i, a, b);
			bw.write(result);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}