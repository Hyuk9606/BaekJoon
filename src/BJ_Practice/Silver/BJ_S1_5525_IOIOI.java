package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_5525_IOIOI {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        System.out.println(solve(N, M, S));
    }
    
    static int solve(int N, int M, String S) {
        int answer = 0;
        
        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'O') continue;
            
            int cnt = 0;
            while(i + 2 < M){
                if(S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I'){
                    i += 2;
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt >= N) {
                answer += cnt - N + 1;
            }
        }
        
        return answer;
    }
}
