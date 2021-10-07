package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_14465_소가_길을_건너간_이유5 {
	static int N,K,B;
	static boolean[] data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int[] PS = new int[N+1];
		Arrays.fill(PS, 1);
		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(br.readLine());
			PS[num] = 0;
		}
		
		for (int i = 1; i <= N; i++) {
			PS[i] += PS[i-1];
		}
		int answer = 0;
		for (int i = K; i <=N; i++) {
			answer = Math.max(answer, PS[i]-PS[i-K]);
		}
		System.out.println(K-answer);
		
	}
}
