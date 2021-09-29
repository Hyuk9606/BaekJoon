package BJ_Practice;
import java.io.*;
import java.util.*;
// 유니온파인드를 써야할 것 같은 느낌이 드는데 구현하는 방법이 기억이 나지 않습니다..
// 교수님 죄송합니다..ㅎㅎ..

public class X_BJ_G4_1707 {
	static int T, V, E; // 입력받을 변수 선언
	static Node[] adjList; // 정점에 대한 정보를 저장할 인접리스트 선언

	// 정점을 저장할 클래스 정의
	static class Node {
		int vertex; // 정점
		Node link; // 연결된 정점

		//생성자 선언
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위한 준비
		StringBuilder sb = new StringBuilder(); // 출력을 위한 준비

		T = Integer.parseInt(br.readLine());	// T 입력
		for (int t = 1; t <= T; t++) { 			// T만큼 반복

			StringTokenizer st = new StringTokenizer(br.readLine());	// V,E를 입력받아 쪼개줌
			V = Integer.parseInt(st.nextToken());	// V 입력
			E = Integer.parseInt(st.nextToken());	// E 입력
			adjList = new Node[V + 1];				// 각 정점의 연결리스트를 adjList의 인덱스에 저장

			for (int i = 0; i < E; i++) {			// E의 갯수만큼 입력받음
				st = new StringTokenizer(br.readLine());	// Token으로 쪼갬
				int start = Integer.parseInt(st.nextToken());	// 시작정점
				int end = Integer.parseInt(st.nextToken());		// 도착정점
				adjList[start] = new Node(end, adjList[start]);	// 연결리스트로 만들어서 인접리스트에 저장
			}
			if(bfs()) 	//bfs를 통해 true를 반환하면 YES, false를 반환하면 NO
				sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
	
	/*
	 * 기본 구상 : 사이클을 만들게 되면 No를 출력, 아니면 Yes를 출력
	 * 인접리스트는 단방향으로 구성되어있으므로 시작 정점에 따라 방문하는 정점이 차이가 있을 것.
	 * 1. 방문하지 않은 모든 정점에서 탐색을 수행, 수행 시 마다 count증가
	 * 2. 방문 시  visited++
	 * 3. 만약 visited가 count와 크거나 같다면 그 지점을 다른 정점을 통해 되돌아 온 것이라 판단(cycle 형성).
	 */
	
	static boolean bfs() {
		boolean flag = true;	// flag 선언
		int[] visited = new int[V + 1];	// 방문체크하기위한 배열 선언
		int count = 0;	// count 변수 선언
		Queue<Integer> queue = new LinkedList<>();	//bfs를 위한 queue 선언
		for (int i = 1; i <= V; i++) {		// 모든 정점에 대해 탐색
			if (visited[i] == 0) {					// 한번도 방문하지 않은 정점에 대해 수행
				count++;							// count증가
				queue.offer(i);						// queue에 정점의 번호를 넣어줌.
			}

			while (!queue.isEmpty()) {				// queue가 비어있지 않으면 계속 탐색
				int cur = queue.poll();				// 현재 탐색하고 있는 정점
				if (visited[cur] >= count) {			// 만약 count보다 visited가 크다면 return false;
					flag = false;
					return flag;
				}
				visited[cur]++;						// count보다 작거나 같다면 ++;

				for (Node temp = adjList[cur]; temp != null; temp = temp.link) {	// 연결된 정점에 대해 탐색 수행
					queue.offer(temp.vertex);
				}
			}
		}
		return flag;	//flag를 반환
	}
}

