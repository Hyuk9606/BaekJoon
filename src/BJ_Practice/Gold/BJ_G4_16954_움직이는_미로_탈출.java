package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_16954_움직이는_미로_탈출 {
    static int[][] maze = new int[8][8];
    static int[][] deltas = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, -1}, {0, -1}, {-1, -1}};
    
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
        
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (str.charAt(j) == '.') maze[i][j] = 0;
                else maze[i][j] = -1;
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(7, 0));
        maze[7][0] = 9;
        int size = 0;
        
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();
                
                if (temp.r == 0 && temp.c == 7) return 1;
                if (maze[temp.r][temp.c] == -1) continue;
                queue.offer(temp);
                
                for (int i = 0; i < 7; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];
                    if (isIn(nr, nc) && maze[nr][nc] == 0) {
                        queue.offer(new Position(nr, nc));
                        maze[nr][nc] = 9;
                    }
                }
            }
            move();
        }
        return 0;
    }
    
    static void move() {
        for (int c = 0; c < 8; c++) {
            if (maze[7][c] == -1) maze[7][c] = 0;
            for (int r = 6; r >= 0; r--) {
                if (maze[r][c] == -1) {
                    maze[r+1][c] = -1;
                    maze[r][c] = 0;
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }
}