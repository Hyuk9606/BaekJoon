package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G4_3055 {
	static int N, M;
	static char[][] map;
	static int[][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static RC HedgeDog;
	static List<RC> flood = new ArrayList<>();
	static RC Dodge;

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];

		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 'S')
					HedgeDog = new RC(r, c);
				else if (map[r][c] == '*')
					flood.add(new RC(r, c));
				else if(map[r][c] == 'D')
					Dodge = new RC(r,c);
			}
		}
		Flood();
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}

		int answer = runAway();
		
		if(answer == -1) System.out.println("KAKTUS");
		else System.out.println(answer);
		
	}

	static void Flood() {
		Queue<RC> queue = new LinkedList<>();
		for (int i = 0; i < flood.size() ; i++) {
			queue.offer(flood.get(i));
			RC temp = flood.get(i);
			visited[temp.r][temp.c] = 1;
		}

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];
				if (isIn(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] == '.') {
					queue.offer(new RC(nr, nc));
					visited[nr][nc] = visited[temp.r][temp.c] + 1;
				}
			}
		}
		visited[Dodge.r][Dodge.c] = 1000;
	}

	static int runAway() {
		Queue<RC> queue = new LinkedList<>();
		boolean[][] route = new boolean[N][M];
		int [][] check = new int[N][M];
		queue.offer(HedgeDog);
		route[HedgeDog.r][HedgeDog.c] = true;
		int runningTime = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				RC temp = queue.poll();

				if (map[temp.r][temp.c] == 'D') {
//					System.out.println(runningTime-1);
//					for (int i = 0; i < N ; i++) {
//						System.out.println(Arrays.toString(check[i]));
//					}
					return runningTime-1;
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = temp.r + deltas[i][0];
					int nc = temp.c + deltas[i][1];

					if (isIn(nr, nc) && !route[nr][nc] ) {
//						System.out.println("run : "+ (runningTime+1) +"/ visit : " + visited[nr][nc] + "/  nr,nc " + nr + " " + nc);
						if(Integer.compare(visited[nr][nc],  runningTime+1)>0) {
							queue.offer(new RC(nr, nc));
							check[nr][nc] = runningTime;							
						}
						route[nr][nc] = true;
					}
				}
			}
			runningTime++;
		}
//		for (int i = 0; i < N ; i++) {
//			System.out.println(Arrays.toString(check[i]));
//		}
		return -1;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
