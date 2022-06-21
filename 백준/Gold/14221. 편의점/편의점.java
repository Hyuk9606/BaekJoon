import java.io.*;
import java.util.*;

public class Main {
    static int N, M, P, Q;
    static int minDist = Integer.MAX_VALUE, answer = 10000;
    static Edge[] adjList;
    static Set<Integer> home = new HashSet<>();
    static Set<Integer> conv = new HashSet<>();
    
    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;
        Edge link;
        
        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        public Edge(int vertex, int weight, Edge link) {
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }
        
        @Override
        public int compareTo(Edge o) {
            if (this.weight == o.weight)
                return Integer.compare(this.vertex, o.vertex);
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adjList = new Edge[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            adjList[start] = new Edge(end, weight, adjList[start]);
            adjList[end] = new Edge(start, weight, adjList[end]);
        }
        
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            home.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            conv.add(Integer.parseInt(st.nextToken()));
        }
        
        dijkstra();
        
        System.out.println(answer);
        
    }
    
    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];
        
        for(int convenience : conv) {
            pq.offer(new Edge(convenience, 0));
            distance[convenience] = 0;
            visited[convenience] = true;
        }
        
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            
            if (home.contains(curr.vertex)) {
                if (minDist > distance[curr.vertex]) {
                    answer = curr.vertex;
                    minDist = distance[curr.vertex];
                } else if (minDist == distance[curr.vertex]) {
                    answer = Math.min(answer, curr.vertex);
                }
            }
            
            visited[curr.vertex] = true;
            
            for (Edge temp = adjList[curr.vertex]; temp != null; temp = temp.link) {
                if (!visited[temp.vertex] && distance[curr.vertex] + temp.weight < distance[temp.vertex]) {
                    pq.offer(new Edge(temp.vertex, distance[curr.vertex] + temp.weight));
                    distance[temp.vertex] = distance[curr.vertex] + temp.weight;
                }
            }
        }
    }
}