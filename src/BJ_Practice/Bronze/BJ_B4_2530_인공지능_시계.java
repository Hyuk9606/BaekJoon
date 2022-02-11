package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B4_2530_인공지능_시계 {
    static int H,M,S;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        N = Integer.parseInt(br.readLine());
        
        H += N/3600;
        N %= 3600;
        M += N / 60;
        N %= 60;
        S += N;
        if(S/ 60 > 0){
            S %= 60;
            M++;
        }
        if(M / 60 > 0){
            M %= 60;
            H++;
        }
        H %= 24;
   
        System.out.println(H + " " + M + " " + S);
    }
}
