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
        int t = Integer.parseInt(br.readLine());    
        
        boolean rangeA = 1 <= A && A <= 1000;
        boolean rangeB = 1 <= B && B <= 1000;
        
        if (t <= 1000000 && rangeA && rangeB) {
            for (int number = 1; number <= t; number++) {
                String str = br.readLine();
                String arr[] = str.split(" ");
                A = Integer.parseInt(arr[0]);
                B = Integer.parseInt(arr[1]);
                
                int result = A + B;
                String resultStr = Integer.toString(result);
                bw.write(resultStr);
                bw.newLine();                 
            }
            bw.flush();
            bw.close();
        } 
        }
    }