import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		Map<String, Integer> books = new HashMap<>();
		for (int i = 0; i < count; i++) {
			String title = br.readLine();
			if (books.get(title) != null) {
				books.put(title, books.get(title) + 1);
			} else {
				books.put(title, 1);
			}
		}
		
		int max = 0;
		String maxTitle = "";
		Set<String> titles = books.keySet();
		for (String title : titles) {
			int sell = books.get(title);
			if (max == sell && maxTitle.compareTo(title) > 0) {
				max = sell;
				maxTitle = title;
			} else if (max < sell) {
				max = sell;
				maxTitle = title;
			}
		}
		
		System.out.println(maxTitle);
	}
}
