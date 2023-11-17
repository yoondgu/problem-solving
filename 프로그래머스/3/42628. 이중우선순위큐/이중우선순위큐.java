import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (String operation : operations) {
            // 삽입 -> 삽입할 때마다 정렬되어야 한다.
            if (operation.startsWith("I")) {                
                int value = Integer.parseInt(operation.split(" ")[1]);
                if (deque.isEmpty()) {
                    deque.addFirst(value);
                    continue;
                }
                // 4 -> 1이 들어오면 앞에 넣기
                int first = deque.peekFirst();
                if (first >= value) {
                    deque.addFirst(value);
                    continue;
                }
                // 1 4 -> 3이 들어오면? 4를 빼고 3 넣고 4 넣기
                int last = deque.peekLast();
                if (last <= value) {
                    deque.addLast(value);                    
                    continue;
                }
                deque.pollLast();
                deque.addLast(value);
                deque.addLast(last);                
            }

            if ("D 1".equals(operation) && !deque.isEmpty()) {
                deque.pollLast();
                
            }
            if ("D -1".equals(operation) && !deque.isEmpty()) {
                deque.pollFirst();
                
            }
        }
                
        if (deque.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int[] answer = new int[2];
        answer[0] = deque.getLast();
        answer[1] = deque.getFirst();
        
        return answer;
    }
}