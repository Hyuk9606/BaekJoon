package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G5_21608_상어_초등학교 {
    static int N;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<Position> studentInfo;
    static int[][] preferInfo;
    static int[][] map;
    static int[][] emptyMap;
    static int[][] preferMap;
    
    static class Position {
        int num;
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
        studentInfo = new ArrayList<>();
        preferInfo = new int[N * N + 1][4];
        map = new int[N][N];
        preferMap = new int[N][N];
        emptyMap = new int[N][N];
        init();
        
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                preferInfo[num][j] = Integer.parseInt(st.nextToken());
            }
            Position p = findPreferSeat(num);
            p.num = num;
            doSit(p);
        }
        System.out.println(calcResult());
    }
    
    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                emptyMap[i][j] = 4;
            }
        }
        for (int i = 0; i < N; i++) {
            emptyMap[i][0]--;
            emptyMap[0][i]--;
            emptyMap[i][N - 1]--;
            emptyMap[N - 1][i]--;
        }
    }
    
    static Position findPreferSeat(int num) {
        int size = studentInfo.size();
        preferMap = new int[N][N];
        for (int i = 0; i < size; i++) {
            Position temp = studentInfo.get(i);
            int curStudent = temp.num;
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (preferInfo[num][j] == curStudent) {
                    flag = true;
                    break;
                }
            }
            if (!flag) continue;
            for (int j = 0; j < 4; j++) {
                int nr = temp.r + deltas[j][0];
                int nc = temp.c + deltas[j][1];
                
                if (!isIn(nr, nc) || map[nr][nc] != 0) continue;
                preferMap[nr][nc]++;
            }
        }
        
        Position result = null;
        int max = -1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] != 0) continue;
                if (preferMap[r][c] > max) {
                    max = preferMap[r][c];
                    result = new Position(r, c);
                }
                if (max == preferMap[r][c]) {
                    result = emptyMap[result.r][result.c] >= emptyMap[r][c] ? result : new Position(r, c);
                }
            }
        }
        return result;
    }
    
    static void doSit(Position p) {
        map[p.r][p.c] = p.num;
        studentInfo.add(p);
        for (int i = 0; i < 4; i++) {
            int nr = p.r + deltas[i][0];
            int nc = p.c + deltas[i][1];
            if (isIn(nr, nc) && map[nr][nc] == 0) {
                emptyMap[nr][nc]--;
            }
        }
    }
    
    static int calcResult() {
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int num = map[r][c];
                int cnt = -1;
                for (int i = 0; i < 4; i++) {
                    int nr = r + deltas[i][0];
                    int nc = c + deltas[i][1];
                    if (!isIn(nr, nc)) continue;
                    
                    for (int j = 0; j < 4; j++) {
                        if (preferInfo[num][j] == map[nr][nc]) {
                            cnt++;
                            break;
                        }
                    }
                }
                answer += (int) Math.pow(10, cnt);
            }
        }
        return answer;
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
