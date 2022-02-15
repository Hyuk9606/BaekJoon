package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B2_20299_3대_측정 {
    static int N,K,L;
    static int Ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sum += a+b+c;
            
            if(!check(a,b,c) || sum < K) continue;
            
            Ans++;
            sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
        }
        System.out.println(Ans);
        System.out.println(sb.toString());
        
    }
    static boolean check(int a,int b, int c){
        return a >= L && b >= L && c >= L;
    }
}
