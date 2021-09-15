package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_G4_1600 {
	static int K, W, H;
	static int[][] map;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[W][H];

		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < H; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
	
	static 
}
