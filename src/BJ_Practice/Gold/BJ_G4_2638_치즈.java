package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_2638_치즈 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int deltas[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while(bfs() != 0) {
			answer++;
		}
		System.out.println(answer);
	}
	
	static int bfs() {
		Queue<RC> queue = new LinkedList<>();
		queue.offer(new RC(0,0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			RC temp = queue.poll();
			
			for (int i = 0; i < 4 ; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					if(map[nr][nc] == 0) queue.offer(new RC(nr,nc));
					else if(map[nr][nc] == 1) map[nr][nc] = 2;
					visited[nr][nc] = true;
				}
			}
		}
		
		for (int i = 0; i < N ; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M ; j++) {
				if(map[i][j] == 2) {
					int cnt = 0;
					for (int k = 0; k < 4 ; k++) {
						int nr = i + deltas[k][0];
						int nc = j + deltas[k][1];
						if(isIn(nr,nc) && map[nr][nc] == 2) {
							cnt++;
						}
					}
					if(cnt<2) map[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M ; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}
		
		return cnt;
		
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
