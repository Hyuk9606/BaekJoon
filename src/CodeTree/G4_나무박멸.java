package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_나무박멸 {
    static int N, M, K, C;
    static int[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int answer = 0;
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        
        for (int i = 0; i < M; i++) {
            nextYear();
            growUp();
            Position pos = findDeadZone();
            if (pos == null) continue;
            setDeadZone(pos);
        }
        System.out.println(answer);
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == -1) {
                    map[r][c] = -10000;
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    static void growUp() {
        int[][] breedMap = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] > 0) {
                    int treeCount = 0, landCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + deltas[d][0];
                        int nc = c + deltas[d][1];
                        if (isIn(nr, nc)) {
                            if (map[nr][nc] == 0) landCount++;
                            else if (map[nr][nc] > 0) {
                                treeCount++;
                            }
                        }
                    }
                    map[r][c] += treeCount;
                    
                    for (int d = 0; d < 4; d++) {
                        int nr = r + deltas[d][0];
                        int nc = c + deltas[d][1];
                        if (isIn(nr, nc) && map[nr][nc] == 0) {
                            breedMap[nr][nc] += map[r][c] / landCount;
                        }
                    }
                }
            }
        }
        breed(breedMap);
    }
    
    static void breed(int[][] breedMap) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] += breedMap[r][c];
                
            }
        }
    }
    
    static Position findDeadZone() {
        int max = 0;
        Position target = null;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int count = 0;
                Position tempPos = new Position(r, c);
                if (map[r][c] > 0) {
                    count += map[r][c];
                    count += scan(tempPos, 1, 1);
                    count += scan(tempPos, -1, 1);
                    count += scan(tempPos, 1, -1);
                    count += scan(tempPos, -1, -1);
                    if (max < count) {
                        max = count;
                        target = tempPos;
                    }
                }
            }
        }
        return target;
    }
    
    static int scan(Position start, int r, int c) {
        int count = 0;
        for (int i = 1; i <= K; i++) {
            int nr = start.r + r * i;
            int nc = start.c + c * i;
            if (isIn(nr, nc) && map[nr][nc] > 0) {
                count += map[nr][nc];
            } else {
                return count;
            }
        }
        return count;
        
    }
    
    static void setDeadZone(Position start) {
        int[] dir = {-1, 1};
        
        if(map[start.r][start.c] == 0){
            map[start.r][start.c] = C * -1 - 1;
            return;
        }
    
        answer += map[start.r][start.c];
        map[start.r][start.c] = C * -1 - 1;
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= K; k++) {
                    int nr = start.r + dir[i] * k;
                    int nc = start.c + dir[j] * k;
                    if(!isIn(nr,nc)) break;
                    if (map[nr][nc] > 0) {
                        if (map[nr][nc] > 0) answer += map[nr][nc];
                        map[nr][nc] = C * -1 - 1;
                    } else if(map[nr][nc] > -10000){
                        map[nr][nc] = C * -1 - 1;
                        break;
                    } else{
                        break;
                    }
                }
            }
        }
    }
    
    static void nextYear() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] < 0 && map[r][c] > -10000)
                    map[r][c]++;
            }
        }
    }
}

