import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());    
        
        if (n <= 100000) {
            for (int number = 0; number < n; number++) {
                int result = n - number;
                bw.write(Integer.toString(result));
                bw.newLine();   
                bw.flush();
            }
            bw.close();
        } 
        }
    }