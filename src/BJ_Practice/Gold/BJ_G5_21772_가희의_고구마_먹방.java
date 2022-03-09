package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_21772_가희의_고구마_먹방 {
    static int R, C, T;
    static int Ans = 0;
    static char[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Position gahee = null;
    
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
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'G') gahee = new Position(i, j);
            }
        }
        dfs(gahee, 0, 0);
        System.out.println(Ans);
    }
    
    static void dfs(Position gahee, int eat, int moveCnt) {
        if (moveCnt >= T) {
            Ans = Math.max(Ans, eat);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = gahee.r + deltas[i][0];
            int nc = gahee.c + deltas[i][1];
            if (isIn(nr, nc) && map[nr][nc] != '#') {
                char prev = map[nr][nc];
                if (prev == 'S') {
                    map[nr][nc] = '.';
                    dfs(new Position(nr, nc), eat+1, moveCnt + 1);
                }
                else
                    dfs(new Position(nr, nc), eat, moveCnt + 1);
                map[nr][nc] = prev;
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
