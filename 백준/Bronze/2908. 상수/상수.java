import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String[] nums = line.split(" ");
		
		StringBuffer sb = new StringBuffer(nums[0]);
		int num1 = Integer.parseInt(sb.reverse().toString());
		
		sb = new StringBuffer(nums[1]);
		int num2 = Integer.parseInt(sb.reverse().toString());
		
		System.out.println(Math.max(num1, num2));
	}
}
