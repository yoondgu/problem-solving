import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			String data = br.readLine();
			Stack<Character> stk = new Stack<>();
			
			boolean isVPS = true;
			for (Character ch : data.toCharArray()) {
				if (ch.equals('(')) {
					stk.add(ch);
				} else {
					if (stk.isEmpty()) {
						isVPS = false;
						break;
					} else {
						stk.pop();
					}
				}
			}
			
			if (!stk.isEmpty()) {
				isVPS = false;
			}
			
			System.out.println(isVPS ? "YES" : "NO");
		}
		
		br.close();
	}
}
