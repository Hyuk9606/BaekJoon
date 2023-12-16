package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_G4_2665_미로만들기 {
    static int N;
    static int[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Position {
        int r, c;
        int blackRoom;
        
        public Position(int r, int c, int blackRoom) {
            this.r = r;
            this.c = c;
            this.blackRoom = blackRoom;
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    
    static void solve() {
        PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.blackRoom));
        boolean[][] visited = new boolean[N][N];
        
        pq.offer(new Position(0, 0, map[0][0]));
        visited[0][0] = true;
        
        while (true) {
            Position temp = pq.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = temp.r + deltas[d][0];
                int nc = temp.c + deltas[d][1];
                if (isIn(nr, nc) && !visited[nr][nc]) {
                    if(nr == N-1 && nc == N-1){
                        System.out.println(temp.blackRoom + map[N-1][N-1]);
                        return;
                    }
                    
                    pq.offer(new Position(nr, nc, temp.blackRoom + map[nr][nc]));
                    visited[nr][nc] = true;
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                char[] str = br.readLine().toCharArray();
                for (int c = 0; c < N; c++) {
                    map[r][c] = Math.abs(str[c] - '1');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
