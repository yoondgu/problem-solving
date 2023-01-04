import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		while ((str = br.readLine())!=null) {
			String[] numbers = str.split(" ");
			System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
		}
		br.close();
	}
}
