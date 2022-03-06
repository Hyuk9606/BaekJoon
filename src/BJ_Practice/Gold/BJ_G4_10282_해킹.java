package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_10282_해킹 {
    static int T;
    static int n, d, c;
    static Edge[] adjList;
    
    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;
        Edge link;
        
        public Edge(int vertex, int weight) {	// 다익스트라에서 쓰기 쉽게하려고 사용.
            this.vertex = vertex;
            this.weight = weight;
        }
        
        public Edge(int vertex, int weight, Edge link) {	// 입력받을 때 사용
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }
        
        @Override
        public int compareTo(Edge o) {					// 다익스트라의 PQ를 위한 것.
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adjList = new Edge[n + 1];
            
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adjList[b] = new Edge(a,s,adjList[b]);
            }
            dijkstra(c);
        }
        System.out.println(sb.toString());
    }
    
    static void dijkstra(int c){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        pq.offer(new Edge(c,0));
        distance[c] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            for(Edge temp = adjList[cur.vertex]; temp != null ; temp = temp.link){
                if(distance[temp.vertex] > distance[cur.vertex]+temp.weight){
                    distance[temp.vertex] = distance[cur.vertex] + temp.weight;
                    pq.offer(new Edge(temp.vertex,distance[temp.vertex]));
                }
            }
        }
        int cnt=0;
        int max=0;
        for (int i = 1; i <= n; i++) {
            if(distance[i] != Integer.MAX_VALUE){
                cnt++;
                max = Math.max(max,distance[i]);
            }
        }
        sb.append(cnt).append(" ").append(max).append("\n");
    }
}
