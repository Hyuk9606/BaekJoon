package CodeTree;

import java.io.*;
import java.util.*;

public class G3_바이러스_실험 {
    static int N, M, K;
    static int[][] map;
    static int[][] nutrients;
    static PriorityQueue<Virus>[] pqs = new PriorityQueue[2];
    static int deltas[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    
    static class Virus {
        int r, c;
        int age;
        
        public Virus(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        nutrients = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                nutrients[r][c] = Integer.parseInt(st.nextToken());
                map[r][c] = 5;
            }
        }
        
        Comparator<Virus> comparator = Comparator.comparingInt(o -> o.age);
        pqs[0] = new PriorityQueue<>(comparator);
        pqs[1] = new PriorityQueue<>(comparator);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            pqs[0].offer(new Virus(r, c, age));
        }
        
        for (int k = 0; k < K; k++) {
            PriorityQueue<Virus> pq = pqs[k % 2];
            List<Virus> deadVirus = new ArrayList<>();
            
            // Step 1.
            while (!pq.isEmpty()) {
                Virus virus = pq.poll();
                if (map[virus.r][virus.c] >= virus.age) {
                    map[virus.r][virus.c] -= virus.age;
                    virus.age++;
                    pqs[(k + 1) % 2].offer(virus);
                } else {
                    deadVirus.add(virus);
                }
            }
            
            // Step 2.
            for (Virus virus : deadVirus) {
                map[virus.r][virus.c] += virus.age / 2;
            }
            
            // Step 3.
            pq = pqs[(k + 1) % 2];
            PriorityQueue<Virus> newPq = new PriorityQueue<>(comparator);
            while (!pq.isEmpty()) {
                Virus virus = pq.poll();
                if (virus.age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nr = virus.r + deltas[d][0];
                        int nc = virus.c + deltas[d][1];
                        if (isIn(nr, nc)) {
                            newPq.offer(new Virus(nr, nc, 1));
                        }
                    }
                }
                newPq.offer(virus);
            }
            pqs[(k + 1) % 2] = newPq;
            
            // finally
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] += nutrients[r][c];
                }
            }
        }
        System.out.println(pqs[K%2].size());
    }
    
    public static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
