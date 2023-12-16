package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_27923_햄최몇 {
    static int N, K, L;
    static int[] hambergers;
    static int[] cokes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        hambergers = new int[N];
        cokes = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hambergers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(st.nextToken()) - 1;
            cokes[k]++;
            if (k + L < N) {
                cokes[k + L]--;
            }
        }
        int now = 0;
        for (int i = 0; i < N; i++) {
            now += cokes[i];
            cokes[i] = now;
        }
        Arrays.sort(cokes);
        Arrays.sort(hambergers);
        double answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.floor(hambergers[i] / Math.pow(2, cokes[i]));
        }
        System.out.println(String.format("%.0f", answer));
    }
}
