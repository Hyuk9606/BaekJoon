package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_16948_데스_나이트 {
    static int N;
    static int r1, r2, c1, c2;
    static int[][] deltas = {{-2, -1}, {-2, 1}, {0, 2}, {0, -2}, {2, -1}, {2, 1}};
    
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
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Position pos1 = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        r2 =  Integer.parseInt(st.nextToken());
        c2 =  Integer.parseInt(st.nextToken());
        bfs(pos1);
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
    
    static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        queue.offer(pos);
        visited[pos.r][pos.c] = true;
        int cnt = 0;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            cnt++;
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();
                
                for (int i = 0; i < 6; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];
                    
                    if (nr == r2 && nc == c2) {
                        System.out.println(cnt);
                        return;
                    }
                    
                    if (isIn(nr, nc) && !visited[nr][nc]) {
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
