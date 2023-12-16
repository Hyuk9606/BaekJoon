package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_2174_로봇_시뮬레이션 {
    static int A, B;
    static int N, M;
    static int[][] deltas = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static char[] direction = {'E', 'S', 'W', 'N'};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Robot[] robots = new Robot[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            for (int direct = 0; direct < 4; direct++) {
                if (direction[direct] == dir) {
                    robots[n] = new Robot(r, c, direct);
                    break;
                }
            }
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            char direction = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            
            if (direction == 'F') {
                for(int step = 0; step < n; step++){
                    robots[num].move();
                    for (int i = 0; i < N; i++) {
                        if(i == num) continue;
                        if(robots[num].isCollision(robots[i])){
                            System.out.println("Robot " + (num + 1) + " crashes into robot " + (i + 1));
                            return;
                        }
                    }
                }
                if (!robots[num].isIn()) {
                    System.out.println("Robot " + (num + 1) + " crashes into the wall");
                    return;
                }
            } else {
                robots[num].turn(direction, n);
            }
        }
        
        System.out.println("OK");
    }
    
    public static class Robot {
        int r, c;
        int dir;
        
        public Robot(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
        
        public boolean isIn() {
            return 0 < this.r && this.r <= A && 0 < this.c && this.c <= B;
        }
        
        public boolean isCollision(Robot other){
            return other.r == this.r && other.c == this.c;
        }
    
        public void move() {
            this.r += deltas[dir][0];
            this.c += deltas[dir][1];
        }
        
        public void turn(char direction, int n) {
            if (direction == 'L') {
                dir = (dir + 3 * n) % 4;
            } else if (direction == 'R') {
                dir = (dir + 1 * n) % 4;
            }
        }
    }
}
