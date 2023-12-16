import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] danger;
    static int[][] death;
    static int[][] map = new int[501][501];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        danger = new int[N][4];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                danger[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        M = Integer.parseInt(br.readLine());
        death = new int[M][4];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                death[m][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        setField(danger, 1);
        setField(death, -1);
        map[0][0] = 0;
        
        System.out.println(bfs());
    }
    
    public static void setField(int[][] coordinate, int value) {
        for (int[] coord : coordinate) {
            int x1 = coord[0];
            int y1 = coord[1];
            int x2 = coord[2];
            int y2 = coord[3];
            
            for (int r = Math.min(x1, x2); r <= Math.max(x1, x2); r++) {
                for (int c = Math.min(y1, y2); c <= Math.max(y1, y2); c++) {
                    map[r][c] = value;
                }
            }
        }
    }
    
    public static int bfs() {
        PriorityQueue<Position> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Position(0, 0, 0));
        map[0][0] = 1000;
        while (!pq.isEmpty()) {
            Position temp = pq.poll();
            
            if (temp.r == 500 && temp.c == 500)
                return temp.cost;
            
            for (int i = 0; i < 4; i++) {
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];
                if (isIn(nr, nc) && 0 <= map[nr][nc] && map[nr][nc] < 1000) {
                    pq.offer(new Position(nr, nc, map[nr][nc] == 1 ? temp.cost + 1 : temp.cost));
                    map[nr][nc] = 1000;
                }
            }
        }
        return -1;
        
    }
    
    public static boolean isIn(int r, int c) {
        return r >= 0 && r <= 500 && c >= 0 && c <= 500;
    }
    
    static class Position {
        int r, c;
        int cost;
        
        public Position(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}
