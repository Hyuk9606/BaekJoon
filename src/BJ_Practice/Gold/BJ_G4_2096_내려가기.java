package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_2096_내려가기 {

	static int N;
	static int[][] data;
	static int[][] dpMax;
	static int[][] dpMin;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N][3];
		dpMax = new int[N][3];
		dpMin = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
			if (i == 0) {
				for (int j = 0; j < 3; j++) {
					dpMax[0][j] = dpMin[0][j] = data[i][j];
					
				}
			} else {
				dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + data[i][0];
				dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + data[i][1];
				dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + data[i][2];
				
				dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + data[i][0];
				dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + data[i][1];
				dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + data[i][2];
			}
		}
		int max = Math.max(dpMax[N-1][0], Math.max(dpMax[N-1][1], dpMax[N-1][2]));
		int min = Math.min(dpMin[N-1][0], Math.min(dpMin[N-1][1], dpMin[N-1][2]));
		
		System.out.println(max + " " + min);
	}

	static boolean isIn(int c) {
		return c >= 0 && c < 3;
	}
}
