package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_2589_보물섬 {
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited = new boolean[N][M];
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Position {
        int r, c;
        
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
        map = new boolean[N][M];
        visited = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            char[] strs = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                switch (strs[m]) {
                    case 'W':
                        map[n][m] = false;
                        break;
                    case 'L':
                        map[n][m] = true;
                        break;
                }
            }
        }
        
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(map[r][c]){
                    visited = new boolean[N][M];
                    int result = bfs(new Position(r,c));
                    max = Math.max(result, max);
                }
            }
        }
        System.out.println(max);
        
    }
    
    static int bfs(Position std) {
        Queue<Position> queue = new LinkedList<>();
        
        queue.offer(std);
        visited[std.r][std.c] = true;
        
        int cnt = 0;
        int maxCnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int step = 0; step < size; step++) {
                Position pos = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = pos.r + deltas[d][0];
                    int nc = pos.c + deltas[d][1];
                    
                    if (isIn(nr, nc) && map[nr][nc] && !visited[nr][nc]) {
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return cnt - 1;
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
