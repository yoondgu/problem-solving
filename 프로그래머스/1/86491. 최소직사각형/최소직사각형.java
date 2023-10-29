class Solution {
    public int solution(int[][] sizes) {
        int[] first = sizes[0];
        int x = first[0];
        int y = first[1];
        for (int i = 1; i < sizes.length; i++) {
            int[] card = sizes[i];
            if ((x >= card[0] && y >= card[1]) || (y >= card[0] && x >= card[1])) {
                continue;
            }

            int s1 = Math.max(card[0], x)*Math.max(card[1], y);
            int s2 = Math.max(card[1], x)*Math.max(card[0], y);
            if (s1 < s2) {
                 x = Math.max(card[0], x);
                 y = Math.max(card[1], y);
            } else {
                x = Math.max(card[1], x);
                y = Math.max(card[0], y);
            }
        }
        
        return x*y;
    }
    
}