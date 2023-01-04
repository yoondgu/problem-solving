import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int result = a*b*c;
		String str = Integer.toString(result);
		
		int[] numbers = new int[str.length()];
		for (int i=0; i<str.length(); i++) {
			numbers[i] = str.charAt(i) - '0'; // char->int 형변환
		}
		
		int[] counter = new int[10];
		for (int i=0; i<numbers.length; i++) {
			counter[numbers[i]]++;
		}
		
		for (int i=0; i<10; i++) {
			System.out.println(counter[i]);
		}
	}
}