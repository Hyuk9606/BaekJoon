package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_14716_현수막 {
    static int N, M;
    static int Answer = 0;
    static int[][] data;
    static int[][] deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 1) {
                    data[i][j] = 0;
                    bfs(new Position(i, j));
                }
            }
        }
        System.out.println(Answer);
    }
    
    static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(pos);
        Answer++;
        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            
            for (int i = 0; i < 8; i++) {
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];
                
                if (isIn(nr, nc) && data[nr][nc] == 1) {
                    queue.offer(new Position(nr, nc));
                    data[nr][nc] = 0;
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
