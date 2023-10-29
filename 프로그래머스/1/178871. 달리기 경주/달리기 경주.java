import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        final Map<String, Integer> indexByPlayer = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            indexByPlayer.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            final String calling = callings[i];
            int index = indexByPlayer.get(calling);
            final String toPass = players[index-1];
            indexByPlayer.replace(calling, index - 1);
            indexByPlayer.replace(toPass, index);
            players[index-1] = calling;
            players[index] = toPass;
        }

        return players;
    }
}