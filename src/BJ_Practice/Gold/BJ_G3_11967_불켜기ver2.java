package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_11967_불켜기ver2 {
    static int N, M;
    static int Ans;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] isShine;     // 불이 켜져있는 방들
    static boolean[][] visited;     // 불을 켠(스위치를 작동한) 방들
    static boolean[][] isPassable;  // 이동할 수 있는 곳(불켠 방의 주변 방들)
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
        isPassable = new boolean[N + 1][N + 1];
        graph = new Position[N + 1][N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[x][y] = new Position(a, b, graph[x][y]);
        }        // 입력 끝
        isShine[1][1] = true;
        visited[1][1] = true;
        Ans++;    // (1,1)은 항상 불이 켜져있다.
        
        bfs();
        
        System.out.println(Ans);
    }
    
    static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        
        queue.offer(new Position(1, 1));
        isPassable[1][1] = true;
        
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            // 불을 켤 수 있는 곳을 모두 켠다.
            for (Position temp = graph[cur.r][cur.c]; temp != null; temp = temp.link) {
                if (!isShine[temp.r][temp.c]) {    // 불이 꺼져있었다면 불을 켜고 갯수를 추가한다.
                    isShine[temp.r][temp.c] = true;
                    Ans++;
                }
                if (isPassable[temp.r][temp.c] && !visited[temp.r][temp.c]) {    // 이동할 수 있는 위치이며, 스위치를 작동시키지 않았다면 queue에 넣는다.
                    queue.offer(new Position(temp.r, temp.c));
                    visited[temp.r][temp.c] = true;
                }
                
            }
            
            for (int i = 0; i < 4; i++) {    // 새로 방문한 방의 사방을 확인한다.
                int nr = cur.r + deltas[i][0];
                int nc = cur.c + deltas[i][1];
                
                if (isIn(nr, nc)) {
                    isPassable[nr][nc] = true;    // 이 때 접근한 모든 방을 이동할 수 있는 방으로 만든다.
                    if (!visited[nr][nc] && isShine[nr][nc]) {    // 불이 켜진 방을 만나면 queue에 넣는다. 이 때 들린 방 중 불 켜진 방이 있다면 queue에 넣는다.
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }
    
}
