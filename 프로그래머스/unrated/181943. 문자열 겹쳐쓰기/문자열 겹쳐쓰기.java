class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        final String first = my_string.substring(0, s);

        answer = first + overwrite_string;

        final String end = my_string.substring(answer.length());
        answer += end;
        
        return answer;
    }
}