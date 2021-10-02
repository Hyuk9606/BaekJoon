package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_11659_구간_합_구하기_4 {
	static int N,M;
	static int i,j;
	static int[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		data = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N ; i++) {
			data[i] = Integer.parseInt(st.nextToken()) + data[i-1];
		}
		
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(-data[Integer.parseInt(st.nextToken())-1] + data[Integer.parseInt(st.nextToken())]).append("\n");
		}
		System.out.println(sb);
		
	}
}
