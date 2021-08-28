package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_2567 {
	static int N;
	static char[][] paper;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		paper = new char[101][101];
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int r = s; r < s+10 ; r++) 
				for (int c = e; c < e+10 ; c++) 
					paper[r][c] = 'X';
		}
		int cnt = 0;
		for (int r = 1; r < 101 ; r++) {
			for (int c = 1; c < 101 ; c++) {
				if(paper[r][c-1] != paper[r][c])
					cnt++;
				if(paper[c][r] != paper[c-1][r])
					cnt++;
			}			
		}
		System.out.println(cnt);
		
	}
}
