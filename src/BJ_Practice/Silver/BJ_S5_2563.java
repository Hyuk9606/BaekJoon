package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_2563 {
	static int N;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int[][] data = new int[100][100];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int x = r; x<r+10; x++) {
				for(int y = c; y<c+10; y++) {
					data[x][y]++;
				}
			}
		}
		int cnt=0;
		for(int i=0; i<100; i++) {
			for(int j = 0; j<100 ; j++) {
				if(data[i][j] != 0) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
