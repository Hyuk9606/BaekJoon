package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_바이러스_백신 {
    static int N, M;
    static int answer = Integer.MAX_VALUE, virusCnt = 0;
    static List<Position> hospitals = new ArrayList<>();
    static boolean[] selected;
    static int[][] map;
    static int deltas[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 0) virusCnt++;
                else if (map[r][c] == 2) hospitals.add(new Position(r, c));
                
            }
        }
        selected = new boolean[hospitals.size()];
        combination(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    
    static void combination(int start, int cnt) {
        if (cnt == M) {
            purification();
            return;
        }
        
        for (int i = start; i < hospitals.size(); i++) {
            selected[i] = true;
            combination(i + 1, cnt + 1);
            selected[i] = false;
        }
    }
    
    static void purification() {
        Queue<Position> queue = new LinkedList<>();
        int[][] visited = new int[N][N];
        for (int i = 0; i < hospitals.size(); i++) {
            Position temp = hospitals.get(i);
            if (selected[i]) {
                queue.offer(temp);
            }
        }
        
        int cnt = 0;
        int checkedVirus = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = temp.r + deltas[d][0];
                    int nc = temp.c + deltas[d][1];
                    
                    if (isIn(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] != 1) {
                        visited[nr][nc] = cnt;
                        if(map[nr][nc] == 0) {
                            checkedVirus++;
                        }
                        queue.offer(new Position(nr, nc));
                    }
                }
            }
        }
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(map[r][c] == 0){
                    max = Math.max(max,visited[r][c]);
                }
            }
        }
        if(virusCnt == checkedVirus)
            answer = Math.min(answer, max);
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
}
