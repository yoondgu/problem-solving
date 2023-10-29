import java.util.HashSet;
import java.util.Set;


class Solution {
    
    static int N;
    static Set<Integer> numSets = new HashSet<>();

    public int solution(String numbers) {
        N = numbers.length();
        String[] nums = new String[N];
        for (int i = 0; i < N; i++) {
            nums[i] = String.valueOf(numbers.charAt(i));
        }

        boolean[] used = new boolean[N];
        for (int i = 1; i <= N; i++) {
            find(used, numbers, "", i);
        }

        return numSets.size();
    }

    private void find(
            boolean[] used,
            String numbers,
            String temp,
            int len
    ) {
        if (temp.length() == len) {
            final int number = Integer.parseInt(temp);
            if (checkNumber(number)) {
                numSets.add(number);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            temp += numbers.charAt(i);
            used[i] = true;
            find(used, numbers, temp, len);
            used[i] = false;
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    private boolean checkNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number != 2 && number%2 == 0) {
            return false;
        }
        for (int i = 3; i < number; i++) {
            if (number%i == 0) {
                return false;
            }
        }
        return true;
    }

}