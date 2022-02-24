package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_S1_18404_현명한_나이트 {
    static int N, M;
    static int[][] map;
    static int[][] deltas = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    
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
        List<Position> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Position knight = new Position(r, c);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list.add(new Position(r,c));
            map[r][c] = -1;
        }
        bfs(knight);
    
        for(Position pos : list){
            sb.append(map[pos.r][pos.c]).append(" ");
        }
        System.out.println(sb.toString());
        
    }
    
    static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        int cnt = 0;
        int size = 0;
        
        queue.offer(pos);
        visited[pos.r][pos.c] = true;
        
        while (!queue.isEmpty()) {
            size = queue.size();
            cnt++;
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];
                    if(isIn(nr,nc) && !visited[nr][nc]){
                        if(map[nr][nc] == -1) map[nr][nc] = cnt;
                        queue.offer(new Position(nr,nc));
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
