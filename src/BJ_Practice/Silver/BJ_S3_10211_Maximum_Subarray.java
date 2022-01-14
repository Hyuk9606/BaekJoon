package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_10211_Maximum_Subarray {
	static int T,N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] data = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N ; i++) {
				data[i] = Integer.parseInt(st.nextToken())+ data[i-1];
			}
			
			int max = data[1];
			for (int i = 1; i <= N ; i++) {
				for (int j = 0; j < i ; j++) {
					max = Math.max(max, data[i]-data[j]);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
