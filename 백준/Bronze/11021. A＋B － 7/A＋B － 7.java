import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A = 1;
        int B = 1;
        String tStr = br.readLine();
        int t = Integer.parseInt(tStr);
        
        boolean isA = 0 < A && A < 10;
        boolean isB = 0 < B && B < 10;
        
            for (int number = 1; number <= t; number++) {
                if (isA && isB){
                    String str = br.readLine();
                    String arr[] = str.split(" ");
                    A = Integer.parseInt(arr[0]);
                    B = Integer.parseInt(arr[1]);
                
                    int result = A + B;
                    String resultStr = Integer.toString(result);
                    bw.write("Case #");
                    bw.write(Integer.toString(number));
                    bw.write(": ");
                    bw.flush();
                    bw.write(resultStr);
                    bw.newLine();
                    bw.flush();
                } 
            }
        bw.close();
        }
    }