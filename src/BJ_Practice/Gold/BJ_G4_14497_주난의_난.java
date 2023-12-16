package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_14497_주난의_난 {
    static int N, M;
    static Position zunan;
    static Position criminal;
    static int[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    
    static void solve() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(zunan);
        visited[zunan.r][zunan.c] = true;
        int cnt = 0;
        while (true) {
            if (queue != null) {
                cnt++;
                queue = gatherZero(queue);
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
    
    static Queue<Position> gatherZero(Queue<Position> start) {
        Queue<Position> ones = new LinkedList<>();
        while (!start.isEmpty()) {
            Position temp = start.poll();
            visited[temp.r][temp.c] = true;
            
            for (int d = 0; d < 4; d++) {
                int nr = temp.r + deltas[d][0];
                int nc = temp.c + deltas[d][1];
                
                if (isIn(nr, nc) && !visited[nr][nc]) {
                    if (nr == criminal.r && nc == criminal.c) {
                        return null;
                    }
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        start.offer(new Position(nr, nc));
                    } else {
                        ones.offer(new Position(nr, nc));
                    }
                }
            }
        }
        
        return ones;
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            
            st = new StringTokenizer(br.readLine());
            zunan = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            criminal = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            
            for (int n = 0; n < N; n++) {
                char[] arrs = br.readLine().toCharArray();
                for (int m = 0; m < M; m++) {
                    if (arrs[m] == '#') {
                        map[n][m] = -2;
                    } else if (arrs[m] == '*') {
                        map[n][m] = -1;
                    } else {
                        map[n][m] = arrs[m] - '0';
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
