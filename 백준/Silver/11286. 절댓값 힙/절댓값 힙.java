import java.util.PriorityQueue;
import java.util.Scanner;

class Number implements Comparable<Number> {

	int value;
	
	public Number(int value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(Number number) {
		int thisAbs = Math.abs(this.value);
		int paramAbs = Math.abs(number.value);
		
		if (this.value == number.value) {
			return 0;
		} else if (thisAbs == paramAbs) {
			return this.value < number.value ? -1 : 1;
		} else if (thisAbs < paramAbs) {
			return -1;
		} else {
			return 1;
		}
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		
		PriorityQueue<Number> prQueue = new PriorityQueue<>();
		for (int i = 0; i < count; i++) {
			int x = scanner.nextInt();
			if (x == 0) {
				Number min = prQueue.poll();
				System.out.println(min == null ? 0 : min.value);
			} else {
				prQueue.add(new Number(x));
			}
		}
	}
}
