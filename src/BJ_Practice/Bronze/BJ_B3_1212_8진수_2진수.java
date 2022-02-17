package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B3_1212_8진수_2진수 {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            String a = Integer.toBinaryString(s.charAt(i) - '0');
            if (a.length() == 2 && i != 0) a = "0" + a;
            else if (a.length() == 1 && i != 0) a = "00" + a;
            
            sb.append(a);
        }
        
        
        System.out.println(sb);
        
    }
}
