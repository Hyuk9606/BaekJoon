package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_15652 {
	static int N;
	static int M;
	static int[] select;
	
	static StringBuilder sb = new StringBuilder();
	
	static void Combination(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start ;i<=N;i++) {
			select[cnt] = i;
			Combination(cnt+1,i);
		}
	}
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			select = new int[M];
			Combination(0,1);
			System.out.println(sb);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
