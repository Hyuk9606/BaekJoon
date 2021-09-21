package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] str1 = (" "+br.readLine()).toCharArray();
		char[] str2 = (" "+br.readLine()).toCharArray();
		int N = str1.length;
		int M = str2.length;
		int[][] LCS = new int[N][M];
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if (str1[i] == str2[j]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}else
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
			}
		}
		
		System.out.println(LCS[N-1][M-1]);
	}
}
