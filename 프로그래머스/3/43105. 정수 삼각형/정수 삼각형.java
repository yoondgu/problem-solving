import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        // 더한 값들을 저장해놓고, 다음 칸에서 더한다.
        // 무조건 한 수만 고를 수 있는 경우와, 두 수 중 큰 값을 골라야 하는 경우가 있다
        // 더한 값들을 저장해둔다.        
        // System.out.println(triangle[2]);
        for (int i=1; i<triangle.length; i++) {
            int[] nodes = triangle[i];
            for (int j=0; j<nodes.length; j++) {
                // 맨 왼쪽인 경우
                if (j == 0) {
                    nodes[j] += triangle[i-1][j];
                    continue;
                }
                // 맨 오른쪽인 경우
                if (j == i) {
                    nodes[j] += triangle[i-1][j-1];
                    continue;
                }
                // 사이에 있는 경우, 위의 두 값을 비교
                int left = triangle[i-1][j-1];
                int right = triangle[i-1][j];
                nodes[j] += Math.max(left, right);
            }
        }
        
        int[] results = triangle[triangle.length - 1];
        int max = -1;
        for (int result : results) {
            max = Math.max(max, result);
        }
        
        return max;
    }

}