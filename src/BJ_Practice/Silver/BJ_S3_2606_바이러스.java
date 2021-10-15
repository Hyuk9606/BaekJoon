package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_2606_바이러스 {
	static int N,M;
	static Node adjList[]; 
	static StringTokenizer st;
	
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adjList = new Node[N+1];
		boolean visited[] = new boolean[N+1];
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjList[start] = new Node(end,adjList[start]);
			adjList[end] = new Node(start,adjList[end]);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(Node temp = adjList[curr]; temp != null ; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex]= true; 
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N ; i++) {
			if(visited[i]) cnt++;
		}
		System.out.println(cnt-1);
		
	}
}
