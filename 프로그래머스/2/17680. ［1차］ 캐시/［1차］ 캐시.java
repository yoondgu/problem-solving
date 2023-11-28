import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> caches = new LinkedList<>();
        
        for (String city : cities) {
            String key = city.toLowerCase();
            if (caches.contains(key)) {
                answer += 1;
                caches.remove(key);
                caches.add(key);
                continue;
            }
            answer += 5;
            if (cacheSize == 0) {
                continue;
            }
            if (caches.size() == cacheSize) {
                String used = caches.poll();
            }
            caches.add(key);
        }
        
        return answer;
    }
}