package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_2252_줄_세우기 {
    static int N, M;
    static Node[] adjList;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();
    
    static class Node {
        int vertex;
        Node link;
        
        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adjList = new Node[N + 1];
        indegree = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            adjList[start] = new Node(end, adjList[start]);
            indegree[end]++;
        }
        bfs();
        System.out.println(sb.toString());
    }
    
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            sb.append(cur).append(" ");
            
            for(Node temp = adjList[cur]; temp != null ; temp = temp.link){
                if(--indegree[temp.vertex] == 0)
                    queue.offer(temp.vertex);
            }
        }
    }
}
