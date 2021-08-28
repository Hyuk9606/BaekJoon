package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B1_13300 {
	static int N, K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] student = new int[2][6];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			student[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
		}
		int cnt = 0;
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 6; j++) {
				cnt += student[i][j] / K;
				if (student[i][j] % K != 0)
					cnt++;
			}
		System.out.println(cnt);
		
	}
}
