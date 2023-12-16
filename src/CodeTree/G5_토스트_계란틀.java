package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_토스트_계란틀 {
    static int N, L, R;
    static int[][] map;
    static int[][] group;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int count = 0;
    
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
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        group = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            group = new int[N][N];
            Map<Integer, Integer> sumMap = grouping();
            boolean flag = setting(sumMap);
            if(!flag) break;
            count++;
        }
        System.out.println(count);
        
    }
    
    
    
    static Map<Integer,Integer> grouping() {
        Queue<Position> queue = new LinkedList<>();
        Map<Integer,Integer> sumMap = new HashMap<>();
        int num = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (group[r][c] != 0) continue;
                queue.offer(new Position(r, c));
                group[r][c] = ++num;
                sumMap.put(num, map[r][c]);
                int count = 1;
                while (!queue.isEmpty()) {
                    Position temp = queue.poll();
                    
                    for (int d = 0; d < 4; d++) {
                        int nr = temp.r + deltas[d][0];
                        int nc = temp.c + deltas[d][1];
                        if(isIn(nr,nc) && group[nr][nc] == 0){
                            int gap = Math.abs(map[temp.r][temp.c] - map[nr][nc]);
                            if( L <= gap && gap <= R){
                                queue.offer(new Position(nr,nc));
                                group[nr][nc] = num;
                                sumMap.put(num,sumMap.get(num)+map[nr][nc]);
                                count++;
                            }
                        }
                    }
                }
                sumMap.put(num,sumMap.get(num)/count);
            }
        }
        return sumMap;
    }
    
    static boolean setting(Map<Integer,Integer> sumMap){
        boolean flag = false;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int num = group[r][c];
                if(!flag && map[r][c] != sumMap.get(num)){
                    flag = true;
                }
                map[r][c] = sumMap.get(num);
            }
        }
        return flag;
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
