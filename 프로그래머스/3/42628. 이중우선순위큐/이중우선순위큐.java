import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(
            (a, b) -> (-1)*Integer.compare(a, b)
        );
        
        for (String operation : operations) {
            // 삽입 -> 삽입할 때마다 정렬되어야 한다.
            if (operation.startsWith("I")) {
                int value = Integer.parseInt(operation.split(" ")[1]);
                minQueue.add(value);
                maxQueue.add(value);
            }
            if (minQueue.isEmpty()) {
                continue;
            }
            if ("D 1".equals(operation)) {
                int max = maxQueue.poll();
                minQueue.remove(max);
            }
            if ("D -1".equals(operation)) {
                int min = minQueue.poll();
                maxQueue.remove(min);
            }
        }
        
        if (minQueue.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int[] answer = new int[2];
        answer[0] = maxQueue.peek();
        answer[1] = minQueue.peek();
        return answer;
    }
}