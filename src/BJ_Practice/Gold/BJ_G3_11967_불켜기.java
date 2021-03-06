package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_11967_불켜기 {
    static int N, M;
    static int Ans;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] isShine;
    static boolean[][] visited;
    static Queue<Position> turnOnList = new LinkedList<>();
    static Position[][] graph;
    
    static class Position {
        int r, c;
        Position link;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        public Position(int r, int c, Position link) {
            this.r = r;
            this.c = c;
            this.link = link;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isShine = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        graph = new Position[N + 1][N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[x][y] = new Position(a, b, graph[x][y]);
        }
        turnOnList.offer(new Position(1, 1));
        isShine[1][1] = true;
        visited[1][1] = true;
        Ans++;
        while (!turnOnList.isEmpty()) {
            while (!turnOnList.isEmpty()) {
                turnOn(turnOnList.poll());
            }
            bfs();
            
        }
        System.out.println(Ans);
    }
    
    static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] check = new boolean[N + 1][N + 1];

//        queue.offer(new Position(1, 1));
//        check[1][1] = true;
        
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (visited[r][c]) {
                    queue.offer(new Position(r, c));
                    check[r][c] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];
                
                if (isIn(nr, nc) && !check[nr][nc] && isShine[nr][nc]) {
                    queue.offer(new Position(nr, nc));
                    turnOnList.offer(new Position(nr, nc));
                    visited[nr][nc] = true;
                    check[nr][nc] = true;
                }
            }
        }
    }
    
    static void turnOn(Position pos) {
        for (Position temp = graph[pos.r][pos.c]; temp != null; temp = temp.link) {
            if (!isShine[temp.r][temp.c]) {
                isShine[temp.r][temp.c] = true;
                Ans++;
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }
    
}
