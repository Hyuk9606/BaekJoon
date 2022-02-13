package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_10804_카드_역배치 {
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        arr = new int[21];
        for (int i = 0; i <= 20; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
    
            for (; s < e; s++, e--) {
                int temp = arr[e];
                arr[e] = arr[s];
                arr[s] = temp;
            }
        }
        for (int i = 1; i <= 20; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
