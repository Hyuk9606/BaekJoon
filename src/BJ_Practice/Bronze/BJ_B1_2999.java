package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B1_2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = str.length();
		int R = 0, C = 0;

		int jj = 1;
		while (jj <= N / 2) {
			for (int i = 1; i <= N / 2; i++) {
				if (i * jj == N && i <= jj && i > R) {
					R = i;
					C = jj;
				}
			}
			jj++;
		}
		if(R==0) {
			R = 1;
			C = N;
		}

		char[][] arr = new char[R][C];
		int k = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				arr[i][j] = str.charAt(k++ % N);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}

//		System.out.println(R + " : " + C);
	}
}
