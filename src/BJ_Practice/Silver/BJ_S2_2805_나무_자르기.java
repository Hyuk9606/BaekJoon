package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_S2_2805_나무_자르기 {
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1){
            System.out.println(arr[0] - M);
            return;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int save = 0;
        int height = 0;
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int cut = arr[i - 1] - arr[i];
            if (cut * i <= M - save) {
                save += cut * i;
            } else {
                height = arr[i - 1];
                cnt = i;
                break;
            }
            height = arr[i];
            cnt = i+1;
        }
        int plus = (M - save) / cnt;
        plus += (M-save) %cnt == 0 ? 0 : 1;
        System.out.println(height - plus);
        
    }
}
