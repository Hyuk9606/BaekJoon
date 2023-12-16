package CodeTree;

import BJ_Practice.Gold.BJ_G4_19238_스타트_택시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_자율주행_전기차 {
    // 최단거리 승객
    // 한칸 1 배터리
    // 목적지 도착 시 소모한 양의 두배 충전
    static int N, M, C;
    static int[][] clientMap;
    static int[][] destMap;
    static Position car;
    static int client;
    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    static class Position implements Comparable<Position> {
        int r, c;
        
        public Position(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
        
        @Override
        public int compareTo(Position o) {
            if (this.r == o.r) {
                return this.c - o.c;
            }
            return this.r - o.r;
        }
    }
    
    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }
    
    static void input() {
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            clientMap = new int[N + 1][N + 1];
            destMap = new int[N + 1][N + 1];
            
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int value = Integer.parseInt(st.nextToken()) * -1;
                    clientMap[r][c] = value;
                    destMap[r][c] = value;
                }
            }
            
            st = new StringTokenizer(br.readLine());
            car = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int startR = Integer.parseInt(st.nextToken());
                int startC = Integer.parseInt(st.nextToken());
                int destR = Integer.parseInt(st.nextToken());
                int destC = Integer.parseInt(st.nextToken());
                clientMap[startR][startC] = i;
                destMap[destR][destC] = i;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    static int solve() {
        for (int step = 0; step < M; step++) {
            int pickUp = findClient();
            
            if (pickUp >= 0 && C >= pickUp) {
                C -= pickUp;
            } else {
                return -1;
            }
            
            int dropOff = calcDistance();
            
            if (dropOff >= 0 && C >= dropOff) {
                C += dropOff;
            } else {
                return -1;
            }
        }
        return C;
    }
    
    static int findClient() {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(car);
        visited[car.r][car.c] = true;
        PriorityQueue<Position> pq = new PriorityQueue<>();
        
        int dist = 0;
        while (!queue.isEmpty()) {
            int step = queue.size();
            for (int i = 0; i < step; i++) {
                Position curr = queue.poll();
                if(clientMap[curr.r][curr.c] > 0){
                    pq.offer(new Position(curr.r, curr.c));
                }
                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + deltas[d][0];
                    int nc = curr.c + deltas[d][1];
                    if (isIn(nr, nc) && !visited[nr][nc] && clientMap[nr][nc] != -1) {
                        visited[nr][nc] = true;
                        queue.offer(new Position(nr, nc));
                    }
                }
            }
            
            if (!pq.isEmpty()) {
                car = pq.poll();
                client = clientMap[car.r][car.c];
                clientMap[car.r][car.c] = 0;
                return dist;
            }
            dist++;
        }
        return -1;
    }
    
    static int calcDistance() {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(car);
        visited[car.r][car.c] = true;
        
        int dist = 1;
        while (!queue.isEmpty()) {
            int step = queue.size();
            for (int i = 0; i < step; i++) {
                Position curr = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + deltas[d][0];
                    int nc = curr.c + deltas[d][1];
                    if (isIn(nr, nc) && !visited[nr][nc] && destMap[nr][nc] != -1) {
                        if (destMap[nr][nc] == client) {
                            destMap[nr][nc] = 0;
                            client = 0;
                            car.r = nr;
                            car.c = nc;
                            return dist;
                        }
                        visited[nr][nc] = true;
                        queue.offer(new Position(nr, nc));
                    }
                }
            }
            dist++;
        }
        return -1;
    }
    
    static boolean isIn(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }
}
