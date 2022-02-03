package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B4_2420_사파리_월드 {
    static long N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Math.abs((long)Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));
        System.out.println(N);
        
    }
}
