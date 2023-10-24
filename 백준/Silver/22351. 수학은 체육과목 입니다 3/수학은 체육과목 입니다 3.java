import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // A 이상 B 이하의 정수를 모두 더한 값
        // 띄어쓰기 없이 적힌 숫자들의 나열을 보고 두 수를 찾기
        // A의 자리수를 가정하고 경우의 수를 나누어 구한다.
        // A와 B 모두 1 이상 999 이하의 정수이다. -> 1자리 수, 2자리 수, 3자리 수
        // 1자리 수인 것부터 찾고 있으면 출력한다.
        final Scanner scanner = new Scanner(System.in);
        final String numbers = scanner.nextLine();

        if (numbers.length() == 1) {
            System.out.println(numbers + " " + numbers);
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (i > numbers.length()) {
                return;
            }

            int start = Integer.parseInt(numbers.substring(0, i));
            int next = start;
            String number = "";

            while (number.length() <= numbers.length()) {
                number += next;
                next++;
                if (number.equals(numbers)) {
                    System.out.println(start + " " + (next-1));
                    return;
                }
            }
        }
    }
}
