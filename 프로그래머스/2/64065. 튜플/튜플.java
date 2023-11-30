import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String tuples = s.substring(1, s.length() - 1);
        String[] sets = tuples.split("},");
        
        int size = sets.length;
        int[] answer = new int[size];
        
        
        // 한개만 들어있는 원소를 먼저 찾는다.
        // 그다음은 두개, 세개, ...
        Set<Integer> results = new LinkedHashSet<>();
        for (int i = 1; i <= size; i++) {
            for (String set : sets) {
                String[] trimed = set.replace("{", "").replace("}", "").split(",");
                if (trimed.length == i) {
                    for (String trim : trimed) {
                        results.add(Integer.parseInt(trim));
                    }
                }
            }
        }
        
        return results.stream()
            .mapToInt(Number::intValue)
            .toArray();
    }
}