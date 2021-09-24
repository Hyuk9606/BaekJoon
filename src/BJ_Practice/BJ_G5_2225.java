package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_2225 {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[][] = new int[201][201];

        // N을 1개로 나눴을 때
        for (int i = 1; i <= 200; i++) {
            arr[0][i] = 1;
        }
        
        for (int i = 1; i <= 200; i++) {
            for (int j = 1 ; j <= 200; j++) {
                arr[i][j] = (arr[i-1][j]+arr[i][j-1])%1000000000;
               
            }
        }
        
//        System.out.println(arr[200][200]);

        System.out.println(arr[N][K]);
        
    }
}
