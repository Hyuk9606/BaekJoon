package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_테트리스_블럭_안의_합 {
    static int N, M;
    static int[][] map;
    static boolean[][] isChecked;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static int max = 0;
    
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
        map = new int[N][M];
        isChecked = new boolean[N][M];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(max);
    }
    
    static List<Position> selectedList = new LinkedList<>();
    static void solve() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                selectedList.add(new Position(r,c));
                isChecked[r][c] = true;
                explore(1,map[r][c]);
                selectedList.remove(0);
            }
        }
    }
    
    static void explore(int cnt, int sum){
        if(cnt == 4){
            max = Math.max(sum,max);
            return;
        }
    
        for (int i = 0; i < selectedList.size(); i++) {
            int r = selectedList.get(i).r;
            int c = selectedList.get(i).c;
    
            for (int d = 0; d < 4; d++) {
                int nr = r + deltas[d][0];
                int nc = c + deltas[d][1];
                if(isIn(nr,nc)){
                    selectedList.add(new Position(nr,nc));
                    isChecked[nr][nc] = true;
                    explore(cnt+1, sum + map[nr][nc]);
                    selectedList.remove(selectedList.size()-1);
                    isChecked[nr][nc] = false;
                }
            }
        }
    }
    
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M && !isChecked[r][c];
    }
}
