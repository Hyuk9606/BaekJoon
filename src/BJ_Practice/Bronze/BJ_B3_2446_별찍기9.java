package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B3_2446_별찍기9 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            print(i);
        }
        for (int i = N-2; i >= 0; i--) {
            print(i);
        }
        System.out.println(sb.toString());
    }
    
    static void print(int i){
        for (int j = 0; j < i; j++) {
            sb.append(" ");
        }
        for (int j = 0; j < (N-i)*2-1; j++) {
            sb.append("*");
        }
        sb.append("\n");
    }
}
