import java.lang.Integer;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
                
        for (int i=0; i<n; i++) {
            // 숫자를 이진수로 바꾼다.
            boolean[] first = toBinary(n, arr1[i]);
            boolean[] second = toBinary(n, arr2[i]);
            
            // 이진수로 바꾼 값을 연산한다.
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                boolean isFirstBlocked = first[j];
                boolean isSecondBlocked = second[j];
                if (isFirstBlocked || isSecondBlocked) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    public boolean[] toBinary(int n, int number) {
        // 2로 나눈 나머지를 구하고, 나눴던 값을 다시 나머지를 구한다.
        // 28 -> (14) 0
        // 14 -> (7) 0
        // 7 -> (3) 1
        // 3 -> (1) 1
        // 1 -> (0) 1
        int divide = number;
        boolean[] binary = new boolean[n];
        for (int i=n-1; i>=0; i--) {
            if (divide == 0) {
                continue;
            }
            if (divide%2 == 1) {
                binary[i] = true;
            }
            divide = divide/2;
        }
        return binary;
    }
}