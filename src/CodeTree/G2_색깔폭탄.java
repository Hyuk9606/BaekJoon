package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_색깔폭탄 {
    static int N, M;
    static int score;
    static int[][] map;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    static class Point {
       
        int r, c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Boom {
        Point standard;
        int count;
        int redCount;
        
        public Boom(Point standard, int count, int redCount) {
            this.standard = standard;
            this.count = count;
            this.redCount = redCount;
        }
        
        @Override
        public String toString() {
            return "Boom{" +
                    "standard=" + standard +
                    ", count=" + count +
                    ", redCount=" + redCount +
                    '}';
        }
    }
    
    public static void main(String[] args) {
        input();
        while (true) {
            Boom b = select();
            if (b.count <= 1) break;
            score += b.count * b.count;
            boomb(b);
            fall();
            rotate();
            fall();
        }
        System.out.println(score);
    }
    
    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static Boom select() {
        Boom target = new Boom(new Point(-1, N), -1000, 1000);
        
        boolean[][] visited = new boolean[N][N];
        List<Point> redBoomList = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 0)
                    redBoomList.add(new Point(r, c));
            }
        }
        
        
        for (int r = N - 1; r >= 0; r--) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] <= 0 || visited[r][c]) continue;
//                redBoomList.forEach(p -> visited[p.r][p.c] = false);
                for(Point item : redBoomList){
                    visited[item.r][item.c] = false;
                }
                Queue<Point> queue = new LinkedList<>();
                int color = map[r][c];
                int count = 0;
                int redCount = 0;
                queue.offer(new Point(r, c));
                visited[r][c] = true;
                while (!queue.isEmpty()) {
                    Point temp = queue.poll();
                    count++;
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = temp.r + deltas[dir][0];
                        int nc = temp.c + deltas[dir][1];
                        if (isIn(nr, nc) && (map[nr][nc] == 0 || map[nr][nc] == color) && !visited[nr][nc]) {
                            queue.offer(new Point(nr, nc));
                            visited[nr][nc] = true;
                            if (map[nr][nc] == 0) redCount++;
                        }
                    }
                }
                Boom tempBoom = new Boom(new Point(r, c), count, redCount);
                target = compareBoom(target, tempBoom) > 0 ? target : tempBoom;
            }
        }
        return target;
    }
    
    static int compareBoom(Boom b1, Boom b2) {
        if (b1.count == b2.count) {
            if (b1.redCount == b2.redCount) {
                if (b1.standard.r == b2.standard.r) {
                    return Integer.compare(b1.standard.c, b2.standard.c) * -1;
                }
                return Integer.compare(b1.standard.r, b2.standard.r);
            }
            return Integer.compare(b1.redCount, b2.redCount) * -1;
        }
        return Integer.compare(b1.count, b2.count);
    }
    
    static void boomb(Boom boom) {
        Point p = boom.standard;
        int color = map[p.r][p.c];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        map[p.r][p.c] = -2;
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = temp.r + deltas[dir][0];
                int nc = temp.c + deltas[dir][1];
                if (isIn(nr, nc) && (map[nr][nc] == 0 || map[nr][nc] == color)) {
                    queue.offer(new Point(nr, nc));
                    map[nr][nc] = -2;
                }
            }
        }
    }
    
    static void fall() {
        for (int c = 0; c < N; c++) {
            for (int r = N - 1; r > 0; r--) {
                if (map[r][c] == -2) {
                    int nr = r - 1;
                    while (nr > 0 && map[nr][c] == -2) {
                        nr--;
                    }
                    if (map[nr][c] >= 0) {
                        map[r][c] = map[nr][c];
                        map[nr][c] = -2;
                    } else if (map[nr][c] == -1) {
                        r = nr;
                    }
                }
            }
        }
    }
    
    static void rotate() {
        int[][] temp = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                temp[N - c - 1][r] = map[r][c];
            }
        }
        map = temp;
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    
}
