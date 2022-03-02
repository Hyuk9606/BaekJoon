package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S5_1292_쉽게_푸는_문제 {
    static int A,B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int answer = 0;
        int current = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                current++;
                if(current > B) {
                    System.out.println(answer);
                    return;
                }
                if(current >= A)
                    answer += i;
                
            }
        }
    }
}
