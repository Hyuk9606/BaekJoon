package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_전투_로봇 {
    static int N, spentTime, killCnt;
    static int[][] map;
    static boolean[][] visited;
    static int level = 2;
    static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Position robot;
    
    static class Position implements Comparable<Position> {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public int compareTo(Position p) {
            if (this.r == p.r)
                return Integer.compare(this.c, p.c);
            return Integer.compare(this.r, p.r);
        }
    }
    
    public static void main(String[] args) {
        // input
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            
            
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] == 9) {
                        robot = new Position(r, c);
                        map[r][c] = 0;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //solve
    
        outer:while (true) {
            Queue<Position> queue = new LinkedList<>();
            PriorityQueue<Position> pq = new PriorityQueue<>();
            visited = new boolean[N][N];
        
            queue.offer(robot);
            visited[robot.r][robot.c] = true;
        
            int cnt = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                cnt++;
                for (int step = 0; step < size; step++) {
                    Position temp = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = temp.r + deltas[d][0];
                        int nc = temp.c + deltas[d][1];
                        if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] <= level){
                            if(map[nr][nc] < level && map[nr][nc] != 0){
                                pq.offer(new Position(nr,nc));
                            }
                            queue.offer(new Position(nr,nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
                if(!pq.isEmpty()){
                    Position target = pq.poll();
                    map[target.r][target.c] = 0;
                    spentTime += cnt;
                    robot = target;
                    
                    killCnt++;
                    if(level == killCnt) {
                        level++;
                        killCnt = 0;
                    }
                    continue outer;
                }
            }
            break;
        }
    
        System.out.println(spentTime);
    
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
}
