package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_9084_동전 {
    static int T, N, M;
    static int[] money;
    static int[] coin;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            money = new int[M+1];
            money[0] = 1;
    
            for (int i = 0; i < N; i++) {
                for (int j = coin[i]; j <= M; j++) {
                    money[j] += money[j-coin[i]];
                }
            }
            sb.append(money[M]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
