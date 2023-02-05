import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    private static int callCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            printCaseResult(bufferedReader.readLine());
        }
    }

    public static void printCaseResult(String s) {
        StringBuilder caseResult = new StringBuilder()
                .append(isPalindrome(s)).append(" ")
                .append(callCounts).append("\n");
        System.out.print(caseResult);
        callCounts = 0;
    }

    public static int recursion(String s, int l, int r){
        callCounts++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length() - 1);
    }
}