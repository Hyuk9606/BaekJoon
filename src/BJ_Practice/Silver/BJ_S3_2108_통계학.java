package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2108_통계학 {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[8001];
        int sum = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            numbers[num + 4000]++;
        }
        sb.append((int) Math.round((double) sum / (double) N)).append("\n");
        
        double mid = N / 2d;
        for (int i = 0; i < 8001; i++) {
            if (mid > 0) {
                mid -= numbers[i];
                if(mid <= 0)
                    sb.append(i - 4000).append("\n");
                continue;
            }
            break;
        }
        
        int count = 0;
        int maximum = 0;
        for (int i = 8000; i >= 0; i--) {
            if(count <= numbers[i]){
                count = numbers[i];
                maximum = i;
            }
        }
        
        int second = -1;
        for (int i = 8000; i > maximum; i--) {
            if(count == numbers[i]){
                second = i;
            }
        }
        
        sb.append(second==-1?maximum-4000 : second-4000).append("\n");
        
        int max = 0, min = 0;
        for (int i = 0; i < 8001; i++) {
            if (numbers[i] != 0) {
                min = i - 4000;
                break;
            }
        }
        
        for (int i = 8000; i >= 0; i--) {
            if (numbers[i] != 0) {
                max = i - 4000;
                break;
            }
        }
        sb.append(max-min).append("\n");
        
        System.out.println(sb.toString());
    }
}
