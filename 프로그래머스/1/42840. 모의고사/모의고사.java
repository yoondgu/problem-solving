import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자의 답을 저장한다.
        // for문 돌면서 정답 count
        Queue<Integer> firstAns = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        Queue<Integer> secondAns = new LinkedList<>(List.of( 2, 1, 2, 3, 2, 4, 2, 5));
        Queue<Integer> thirdAns = new LinkedList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        // 정답 카운트할 때마다 빼고 뒤에 넣는다.
        Map<Integer, Integer> score = new HashMap<>();
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 0);

        for (int i : answers) {
            final Integer first = firstAns.poll();
            if (first == i) {
                score.put(1, score.getOrDefault(1, 0) + 1);
            }
            firstAns.add(first);

            final Integer second = secondAns.poll();
            if (second == i) {
                score.put(2, score.getOrDefault(2, 0) + 1);
            }
            secondAns.add(second);

            final Integer third = thirdAns.poll();
            if (third == i) {
                score.put(3, score.getOrDefault(3, 0) + 1);
            }
            thirdAns.add(third);
        }

        List<Integer> scores = new ArrayList<>(score.values());
        Collections.sort(scores, Comparator.reverseOrder());
        final Integer max = scores.get(0);

        final List<Integer> winners = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            final Integer playerScore = score.get(i);
            if (playerScore.equals(max)) {
                winners.add(i);
            }
        }

        int[] answer = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }
        
        return answer;
    }
}