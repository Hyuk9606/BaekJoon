import java.util.*;
class Solution {
    public static Node[] adjList;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        adjList = new Node[n+1];
        for(int[] e : edge){
            adjList[e[0]] = new Node(e[1],adjList[e[0]]);
            adjList[e[1]] = new Node(e[0],adjList[e[1]]);
        }
        answer = bfs(n);
        return answer;
    }
    
    public int bfs(int n){
        int[] visited = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count = 1;
        visited[1] = count;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int step = 0; step < size; step++){
                int cur = queue.poll();
                
                for(Node temp = adjList[cur]; temp != null; temp = temp.link){
                    if(visited[temp.vertex] != 0) continue;
                    visited[temp.vertex] = count;
                    queue.offer(temp.vertex);
                }
            }
        }
        
        int result = 0;
        count--;
        for(int cnt : visited){
            if(cnt == count) result++;
        }
        return result;
        
    }
    
    public class Node{
        int vertex;
        Node link;
        
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
}