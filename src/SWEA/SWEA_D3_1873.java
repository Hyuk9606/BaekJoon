package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_1873 {
	static int T;
	static int H, W;
	static int N;
	static int curR, curC;
	static char curD;

	static char[][] map;
	static char[] control;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	static int checkDir(char c) {
		switch (c) {
		case 'U':
			return 0;
		case 'D':
			return 1;
		case 'L':
			return 2;
		case 'R':
			return 3;
		case 'S':
			return 4;
		}
		return 0;
	}

	static char curDir(char c) {
		switch (c) {
		case '>':
			return 'R';
		case '<':
			return 'L';
		case '^':
			return 'U';
		case 'v':
			return 'D';
		}
		return ' ';
	}

	static void change(int direction) {
		if (direction == 0)
			curD = '^';
		else if (direction == 1)
			curD = 'v';
		else if (direction == 2)
			curD = '<';
		else
			curD = '>';
	}

	static void swap(int r, int c, int nr, int nc) {
		char temp;
		temp = map[nr][nc];
		map[nr][nc] = map[r][c];
		map[r][c] = temp;
		curR = nr;
		curC = nc;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int r = 0; r < H; r++) {
				map[r] = br.readLine().toCharArray();
			}

			N = Integer.parseInt(br.readLine());
			control = br.readLine().toCharArray();

			outer: for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (map[r][c] == '>' || map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<') {
						curR = r;
						curC = c;
						curD = map[r][c];
						break outer;
					}

				}
			}
			for (int i = 0; i < N; i++) {
				int direction = checkDir(control[i]);
				if (checkDir(control[i]) == 4) {
					int shotDir = checkDir(curDir(curD));
					int nr = curR + deltas[shotDir][0];
					int nc = curC + deltas[shotDir][1];
					while (isIn(nr, nc) && map[nr][nc] != '#') {
						if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
						else if(map[nr][nc] == '-') {
							nr += deltas[shotDir][0];
							nc += deltas[shotDir][1];
							continue;
						}
						map[nr][nc] = '.';
						nr += deltas[shotDir][0];
						nc += deltas[shotDir][1];
					}
				} else {
					change(direction);
					map[curR][curC] = curD; 
					int nr = curR + deltas[direction][0];
					int nc = curC + deltas[direction][1];
					if (isIn(nr, nc) && map[nr][nc] == '.')
						swap(curR, curC,nr,nc);
				}

			}
			
			sb.append("#").append(t).append(" ");
			for(int i=0; i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			

		}
		System.out.println(sb.toString());

	}
}
