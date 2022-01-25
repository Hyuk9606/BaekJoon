package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S5_1789_수들의_합 {
    static long S;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        S = Long.parseLong(br.readLine());
        int i = 1;
        while (true) {
            S -= i++;
            if(S < 0){
                i-=2;
                break;
            }else if(S == 0){
                i--;
                break;
            }
        }
        System.out.println(i);
    }
}
