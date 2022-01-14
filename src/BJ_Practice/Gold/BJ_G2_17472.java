package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G2_17472 {
	static int N, M, count;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "RC [r=" + r + ", c=" + c + "]";
		}

	}

	static List<Edge> edgeList = new ArrayList<>();

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + ", weight=" + weight + "]\n";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = classifyIsland();

//		for (int i = 0; i < N ; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();

		int[][] adjMatrix = checkConnected();
//		for (int i = 1; i <=count ; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}
//		
		int[] minEdge = new int[count + 1];
		Arrays.fill(minEdge, 20000);
		boolean[] visited = new boolean[count + 1];

		int result = 0; // 최소신장트리 비용
		minEdge[1] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅

		for (int i = 1; i <= count; i++) {
			// 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 1; j <= count; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true; // 신장트리에 포함시킨
//			System.out.println(minVertex);
			result += min;

			// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			for (int j = 1; j <= count; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		if (!(result < 1000 && result > 0))
			result = -1;

		boolean flag = false;
		for (int i = 1; i <= count; i++) {
			if (!visited[i]) {
				flag = false;
				break;
			}
			flag = true;
		}
		if (flag)
			System.out.println(result);
		else System.out.println(-1);

	}
	
	// 섬 구분하기
	
	static int classifyIsland() {	
		int count = 1;
		boolean[][] visited = new boolean[N][M];
		Queue<RC> queue = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					queue.offer(new RC(r, c));
					visited[r][c] = true;

					while (!queue.isEmpty()) {
						RC temp = queue.poll();
						map[temp.r][temp.c] = count;
						for (int i = 0; i < 4; i++) {
							int nr = temp.r + deltas[i][0];
							int nc = temp.c + deltas[i][1];
							if (isIn(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
								queue.offer(new RC(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
					count++;
				}
			}
		}
		return count - 1;
	}
	
	// 다리가 연결되어 있다면 인접행렬 만들기.
	
	static int[][] checkConnected() {	
		int[][] adjMatrix = new int[count + 1][count + 1];
		for (int i = 0; i < count + 1; i++) {
			Arrays.fill(adjMatrix[i], 20000);
		}
		for (int r = 0; r < N; r++) {
			int start = 0, end = 0, count = 0;
			for (int c = 1; c < M; c++) {
				if (map[r][c - 1] != map[r][c]) {
					if (start == 0 && map[r][c - 1] != 0)
						start = map[r][c - 1];
					else if (start != 0)
						end = map[r][c];
				}
				if (end != 0) {
					if (count > 1) {
						adjMatrix[start][end] = Math.min(adjMatrix[start][end], count);
						adjMatrix[end][start] = Math.min(adjMatrix[end][start], count);
					}
					start = end;
					end = 0;
					count = 0;
				} else if (start != 0 && map[r][c] != start) {
					count++;
				}

			}
		}
		for (int c = 0; c < M; c++) {
			int start = 0, end = 0, count = 0;
			for (int r = 1; r < N; r++) {
				if (map[r - 1][c] != map[r][c]) {
					if (start == 0 && map[r - 1][c] != 0)
						start = map[r - 1][c];
					else if (start != 0)
						end = map[r][c];
				}
				if (end != 0) {
					if (count > 1) {
						adjMatrix[start][end] = Math.min(adjMatrix[start][end], count);
						adjMatrix[end][start] = Math.min(adjMatrix[end][start], count);
					}
					start = end;
					end = 0;
					count = 0;
				} else if (start != 0 && map[r][c] != start) {
					count++;
				}

			}
		}
		return adjMatrix;

	}
	
	

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
