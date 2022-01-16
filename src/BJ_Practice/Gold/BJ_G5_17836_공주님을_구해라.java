package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_17836_공주님을_구해라 {
    static int N, M, T;
    static int answer = 10001;
    static int[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Position sword;
    
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
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) sword = new Position(i, j);
            }
        }
        
        bfs();
        System.out.println(answer > T ? "Fail" : answer);
        
    }
    
    static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));
        visited[0][0] = true;
        int count = -1;
        int size = 0;
        while (!queue.isEmpty()) {
            count++;
            size = queue.size();
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();
                
                // 검을 찾으면 여태 걸린 시간 + 도착지까지의 거리를 더해 Answer에 반영한다.
                // 도착지에 도달하는 시간보다 더 느릴 수 없다.
                // Queue에 삽입해서 다음 위치를 계산해 볼 필요는 없으므로 continue
                if (temp.r == sword.r && temp.c == sword.c) {
                    answer = count + N - 1 - sword.r + M - 1 - sword.c;
                    continue;
                }
                
                // 도착지에 도달하면 걸린 시간과 Answer를 비교해 더 작은 값으로 반영한다.
                else if (temp.r == N - 1 && temp.c == M - 1) {
                    answer = Math.min(answer, count);
                    return;
                }
                
                for (int i = 0; i < 4; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];
                    
                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                        
                    }
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
