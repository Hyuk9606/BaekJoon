package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_1149 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int[][] colorCost = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			colorCost[i][0] = Integer.parseInt(st.nextToken());
			colorCost[i][1] = Integer.parseInt(st.nextToken());
			colorCost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= N ; i++) {
			for (int j = 0; j < 3 ; j++) {
				int min = 9999999;
				for (int k = 0; k < 3 ; k++) {
					if(k != j)
						min = Integer.min(min, colorCost[i-1][k]);
				}
				colorCost[i][j] += min;
			}
		}
		
		int answer = 99999999;
		
		for (int i = 0; i < 3 ; i++) {
			answer = Integer.min(colorCost[N][i],answer);
		}
//		for (int i = 1; i <= N ; i++) {
//			System.out.println(Arrays.toString(colorCost[i]));
//		}
		System.out.println(answer);
	}
}
