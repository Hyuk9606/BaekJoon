package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_15651 {
	static int N;
	static int M;
	static int[] select;
	static StringBuilder sb = new StringBuilder();
	static void Combination(int cnt) {
		if(cnt == M) {
			for(int i= st; i<M; i++) {
			sb.append(select[i]).append(" ");	
			}
			sb.append("\n");
			
			return;
		}
		for(int i=1; i<=N; i++) {
			
			select[cnt] = i;
			Combination(cnt+1);
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			select = new int[N+1];
			Combination(0);
			System.out.println(sb);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
