import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String tuples = s.substring(1, s.length() - 1);
        String[] sets = tuples.split("},");
        
        int size = sets.length;
        int[] answer = new int[size];
        boolean[] isCounted = new boolean[1_000_001];
        
        
        for (int i = 1; i <= size; i++) {
            boolean find = false;
            for (String set : sets) {
                String[] trimed = set.replace("{", "").replace("}", "").split(",");
                if (trimed.length == i) {
                    for (String trim : trimed) {
                        int value = Integer.parseInt(trim);
                        if (isCounted[value]) {
                            continue;
                        }
                        answer[i-1] = value;
                        isCounted[value] = true;     
                        find = true;
                        break;
                    }
                }
                if (find) {
                    continue;
                }
            }
        }
        
        return answer;
    }
}