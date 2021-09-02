package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_15681 {

	static int N, R, Q;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		List<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			arr[U].add(V);
			arr[V].add(U);
		}


		int count[] = new int[N+1];
		
	
	}
	
}
