package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_2293_동전1 {
    static int N, K;
    static int[] money;
    static int[] coin;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        coin = new int[N];
        money = new int[K+1];
        
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        money[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= K; j++) {
                money[j] += money[j-coin[i]];
            }
        }
    
        System.out.println(money[K]);
    }
}
