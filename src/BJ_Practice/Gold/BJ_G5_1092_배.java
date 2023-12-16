package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G5_1092_배 {
    static int N, M;
    static int[] crains;
    static int[] boxes;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crains = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crains[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crains);
        
        M = Integer.parseInt(br.readLine());
        boxes = new int[M];
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
            if (boxes[i] > crains[N - 1]) {
                System.out.println(-1);
                return;
            }
        }
        Arrays.sort(boxes);
        
        
    }
}
