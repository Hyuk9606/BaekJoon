package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_16987_계란으로_계란치기 {
    static int N, answer;
    static int[] weights;
    static int[] durabilities;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        durabilities = new int[N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durabilities[r] = Integer.parseInt(st.nextToken());
            weights[r] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(answer);
    }
    
    static void solve(int level, int sum) {
        if (level == N) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (i == level || durabilities[i] <= 0) continue;
            if (durabilities[level] <= 0) {
                solve(level + 1, sum);
                return;
            }
            durabilities[level] -= weights[i];
            durabilities[i] -= weights[level];
            int cnt = 0;
            if (durabilities[level] <= 0)
                cnt++;
            if (durabilities[i] <= 0)
                cnt++;
            
            solve(level + 1, sum + cnt);
            durabilities[level] += weights[i];
            durabilities[i] += weights[level];
        }
    }
}
