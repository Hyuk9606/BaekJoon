package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_2805 {
	static int T;
	static int N;
	static int[][] map;
	static int sum = 0;

	
	static void profit() {
		int cnt = 1;
		for(int r=0; r<N/2; r++) {
			int count = 0;
			for(int c=(N/2)-r; c<N; c++) {
				sum += map[r][c];
				count++;
				if(count == cnt) {
					cnt+=2;									
					break;
				}
			}
		}
		for(int r=N/2; r<N; r++) {
			int count = 0;
			for(int c=r - (N/2); c<N; c++) {
				sum += map[r][c];
				count++;
				if(count == cnt) {
					cnt-=2;									
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sum = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j] - '0';
				}
			}
			profit();
			System.out.println("#"+t+" "+ sum);
		}
	}
}
