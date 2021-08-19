package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G2_3109 {
	static int R, C;
	static int cnt = 0;
	static boolean flag = false;
	static char[][] map;
	static int[][] deltas = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			map = steal(i, 0, map);
			flag = false;
		}

//		for (char[] x : map)
//			System.out.println(Arrays.toString(x));
		for (int i = 0; i < R ; i++) {
			if(map[i][C-1] == 'O')
			cnt++;
		}

		System.out.println(cnt);

	}

	static char[][] steal(int rowNo, int colNo, char[][] map) {
		int r = rowNo;
		int c = colNo;
		
		if(c==C-1) {
			flag = true;
			return map;
		}
		
		for (int col = 0; col < 3; col++) {
			int nr = r + deltas[col][0];
			int nc = c + deltas[col][1];
			if (isIn(nr, nc) && map[nr][nc] == '.') {
				map[nr][nc] = 'O';
				steal(nr,nc,map);
			}
			
			if(flag == true) return map;
		}
		return map;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
