package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_9372 {
	
	static int T,N,M;
	static int[][] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M ; i++) {
				br.readLine();
			}
			System.out.println(N-1);
		}
	}
}
