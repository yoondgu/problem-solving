import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> rates = new HashMap<>();
        
        // 스테이지의 개수: N
        // 실패율 구하기
        // 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        // 도달한 유저가 없으면 0으로 처리할 것
        
        // 사용자가 현재 멈춰있는 스테이지의 번호: N+1이 아니면 도전 중인 것이고, N+1이면 클리어한 것
        
        // 각 스테이지마다 도달한 플레이어 수, 아직 클리어하지 못한 플레이어 수를 구한다.
        // 도달한 플레이어 수: stages 값이 해당 스테이지보다 큰 경우
        // 아직 클리어하지 못한 플레이어 수: stages 값이 해당 스테이지인 경우
        Arrays.sort(stages);
        
        for (int level=1; level<=N; level++) {
            // stages에서 level보다 큰 경우의 개수를 찾는다. -> 정렬 시키고 가장 먼저 등장하는 수를 찾기?
            int cleared = 0;
            int failed = 0;
            for (int i=0; i<stages.length; i++) {
                if (stages[i] == level) {
                    failed++;
                }
                if (stages[i] >= level) {
                    cleared++;
                }
            }
            
            double rate = 0;
            if (cleared > 0) {
                rate = failed/(cleared*(1.0));
            }
            rates.put(level, rate);
        }
        
        int[] answer = rates.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .mapToInt(entry -> entry.getKey())
            .toArray();
        
        return answer;
    }
}