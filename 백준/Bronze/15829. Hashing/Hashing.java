import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long M = 1234567891;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] strArr = br.readLine().toCharArray();
        
        long answer = 0;
        for (int i = 0; i < L; i++) {
            answer += pow(i) * (long)(strArr[i] - 'a' + 1) % M;
            answer %= M;
        }
        
        System.out.println(answer);
        
    }
    
    public static long pow(int i) {
        long a = 1;
        for (int j = 0; j < i; j++) {
            a = a * 31 % M;
        }
        return a % M;
    }
}