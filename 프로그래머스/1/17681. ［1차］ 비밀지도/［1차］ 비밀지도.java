import java.lang.Integer;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
                
        for (int i=0; i<n; i++) {
            // 숫자를 이진수로 바꾼다.
            String first = Integer.toBinaryString(arr1[i]);
            String second = Integer.toBinaryString(arr2[i]);
            
            if (first.length() < n) {
                first = "0".repeat(n - first.length()) + first;
            }
            if (second.length() < n) {
                second = "0".repeat(n - second.length()) + second;
            }
            
            // 이진수로 바꾼 값을 연산한다.
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                char firstValue = first.charAt(j);
                char secondValue = second.charAt(j);
                if ('1' == firstValue || '1' == secondValue) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        // 이진수 연산 ..
        return answer;
    }
}