package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_21921_블로그 {
    static int N,X;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        
        if(arr[N] == 0) {
            System.out.println("SAD");
            return;
        }
        int count = 0;
        int max = 0;
        for (int i = X; i <= N; i++) {
            int num = arr[i] - arr[i-X];
            if(max < num){
                count = 1;
                max = num;
            }else if(max == num){
                count += 1;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }
}
