package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B1_10163 {
	static int N;
	static int[][] paper = new int[1001][1001];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for (int r = x; r < x+width; r++) {
				for (int c = y; c < y + height; c++) {
					paper[r][c] = i+1;
				}
			}
		}
		int[] answer = new int[N];
		for (int r = 0; r < 1001 ; r++) {
			for (int c = 0; c < 1001 ; c++) {
				if(paper[r][c] != 0) {
					answer[paper[r][c]-1]++;
				}
			}			
		}
		for (int i = 0; i < N ; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		System.out.println(sb);

	}
}
