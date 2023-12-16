package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_미로_타워_디펜스 {
    static int N, M;
    static int score;
    static int[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        input();
        solve();
    }
    
    static void input() {
        try {
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
    static void solve(){
        for (int i = 0; i < M; i++) {
            attack();
            Queue<Integer> queue = gather();
            int size = queue.size();
        
            queue = bomb(queue);
            while (size != queue.size()) {
                size = queue.size();
                queue = bomb(queue);
            }
            queue = pairing(queue);
            setMap(queue);
        }
        System.out.println(score);
    }
    
    static void attack() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            int nr = N / 2;
            int nc = N / 2;
            for (int i = 0; i < p; i++) {
                nr += deltas[d][0];
                nc += deltas[d][1];
                score += map[nr][nc];
                map[nr][nc] = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static Queue<Integer> gather() {
        Queue<Integer> queue = new LinkedList<>();
        int dir = 2;
        int nr = N / 2;
        int nc = N / 2;
        
        for (int i = 0; i < N * 2 - 1; i++, dir = (dir + 3) % 4) {
            for (int j = 0; j <= i / 2; j++) {
                nr += deltas[dir][0];
                nc += deltas[dir][1];
                
                if (isNotIn(nr, nc))
                    break;
                
                if (map[nr][nc] == 0) continue;
                queue.offer(map[nr][nc]);
                map[nr][nc] = 0;
            }
        }
        return queue;
    }
    
    static Queue<Integer> bomb(Queue<Integer> queue) {
        Queue<Integer> subQ = new LinkedList<>();
        int cnt = 1;
        int curNum = 0;
        while (!queue.isEmpty()) {
            curNum = queue.poll();
            while (!queue.isEmpty() && queue.peek() == curNum) {
                queue.poll();
                cnt++;
            }
            if (cnt < 4) {
                for (int i = 0; i < cnt; i++) {
                    subQ.offer(curNum);
                }
            }else {
                score += curNum * cnt;
            }
            cnt = 1;
        }
        
        return subQ;
    }
    
    static Queue<Integer> pairing(Queue<Integer> queue){
        Queue<Integer> subQ = new LinkedList<>();
        while(!queue.isEmpty()){
            int curNum = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty() && queue.peek() == curNum){
                queue.poll();
                cnt++;
            }
            subQ.offer(cnt);
            subQ.offer(curNum);
        }
        return subQ;
    }
    
    static void setMap(Queue<Integer> queue){
        int dir = 2;
        int nr = N / 2;
        int nc = N / 2;
    
        for (int i = 0; i < N * 2 - 1; i++, dir = (dir + 3) % 4) {
            for (int j = 0; j <= i / 2; j++) {
                nr += deltas[dir][0];
                nc += deltas[dir][1];
                
                if(isNotIn(nr,nc)) break;
                
                map[nr][nc] = queue.poll();
                if(queue.isEmpty()) return;
            }
        }
    }
    static boolean isNotIn(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }
}
