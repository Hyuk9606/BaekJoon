package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_17129_윌리암슨수액빨이딱따구리가_정보섬에_올라온_이유 {
    static int N, M;
    static int[][] map;
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
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Position curr = null;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 2)
                    curr = new Position(i, j);
            }
        }
        bfs(curr);
    }
    
    static void bfs(Position curr) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(curr);
        map[curr.r][curr.c] = -1;
        
        int size = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            count++;
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];
                    if (isIn(nr, nc) ){
                        if(map[nr][nc] >1){
                            System.out.println("TAK");
                            System.out.println(count);
                            return;
                        }
        
                        if(map[nr][nc] == 0){
                            queue.offer(new Position(nr, nc));
                            map[nr][nc] = -1;
                        }
                    }
                }
            }
        }
        System.out.println("NIE");
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
