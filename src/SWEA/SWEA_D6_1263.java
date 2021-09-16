package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D6_1263 {
	static int T, N;
	static Node[] adjList;
	static boolean[] visited;
	static final int INFINITY = 987654321;

	static StringTokenizer st;

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			int data[][] = new int[N+1][N+1];
			
			for (int i = 1; i <= N ; i++) {
				for (int j = 1; j <= N ; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					data[i][j] = data[i][j]==0? INFINITY : data[i][j];
				}
			}
			
			for (int k = 1; k <= N ; k++) {
				for (int i = 1; i <= N ; i++) {
					if(i != k)
					for (int j = 1; j <= N ; j++) {
						if(i!= j && j != k)
							data[i][j] = Math.min(data[i][k]+data[k][j], data[i][j]);
					}
				}
				
			}
			System.out.println();
			int answer=INFINITY;
			for (int i = 1; i <= N ; i++) {
				int result = 0;
				for (int j = 1; j <= N ; j++) {
					if(i!=j)
						result += data[i][j];
				}
				answer = Math.min(answer, result);
			}
			bw.write("#"+t+" "+answer+"\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		T = Integer.parseInt(br.readLine());
//		for (int t = 1; t <= T; t++) {
//			st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			adjList = new Node[N + 1];
//			
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					if (st.nextToken().equals("1")) {
//						adjList[i] = new Node(j, adjList[i]);
//					}
//				}
//			}
//			int answer = bfs();
//			sb.append("#").append(t).append(" ").append(answer).append("\n");
//			
//		}
//		System.out.println(sb);
//	}
//
//	static int bfs() {
//		Queue<Integer> queue;
//		int answer = 987654321;
//		for (int i = 1; i <= N; i++) {
//			visited = new boolean[N + 1];
//			queue = new LinkedList<>();
//			
//			queue.offer(i);
//			visited[i] = true;
//			int depth = 0;
//			int result = 0;
//			while (!queue.isEmpty()) {
//
//				int step = queue.size();
//				result += depth * step;
//				while (step-- > 0) {
//					int current = queue.poll();
//					for (Node temp = adjList[current]; temp != null; temp = temp.link) {
//						if (!visited[temp.vertex]) {
//							queue.offer(temp.vertex);
//							visited[temp.vertex] = true;
//						}
//					}
//				}
//				depth++;
//			}
//			answer = Integer.min(answer, result);
//		}
//		return answer;
//	}

}
