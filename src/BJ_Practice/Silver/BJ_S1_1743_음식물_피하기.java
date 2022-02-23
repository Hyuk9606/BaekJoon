package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1743_음식물_피하기 {
    static int N, M, K;
    static boolean[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Position{
        int r,c;
    
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            map[r][c] = true;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]){
                    ans = Math.max(ans, bfs(new Position(i,j)));
                }
            }
        }
    
        System.out.println(ans);
        
    }
    
    static int bfs(Position pos){
        Queue<Position> queue = new LinkedList<>();
        queue.offer(pos);
        map[pos.r][pos.c] = false;
        int cnt = 1;
    
        while (!queue.isEmpty()) {
            Position temp = queue.poll();
    
            for (int i = 0; i < 4; i++) {
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];
                if(isIn(nr,nc) && map[nr][nc]){
                    queue.offer(new Position(nr,nc));
                    map[nr][nc] = false;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    static boolean isIn(int r, int c){
        return r>=0 && r < N && c>=0 && c < M;
    }
}
