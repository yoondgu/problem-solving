import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            // 지금이 )이고 바로 마지막 거가 (이면 그대로
            // )이면 다시 넣고 now도 넣기
            if (')' == now) {
                if (stack.isEmpty()) {
                    return false;
                }
                char before = stack.peek();
                if ('(' == before) {
                    stack.pop();
                } else {
                    stack.push(now);
                }
            } else {
                stack.push(now);                
            }
        }

        return stack.isEmpty();
    }
}