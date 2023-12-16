package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_18405_경쟁적_전염 {
    static int N, K;
    static int S, X, Y;
    static int[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<Virus>[] qList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        qList = new Queue[K + 1];
        for (int k = 1; k <= K; k++) {
            qList[k] = new LinkedList<>();
        }
        
        for (int n1 = 1; n1 <= N; n1++) {
            st = new StringTokenizer(br.readLine());
            for (int n2 = 1; n2 <= N; n2++) {
                int value = Integer.parseInt(st.nextToken());
                map[n1][n2] = value;
                if (value != 0) {
                    qList[value].offer(new Virus(n1, n2));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        bfs();
    
        System.out.println(map[X][Y]);
    }
    
    static void bfs() {
        while (S-- > 0) {
            for (int k = 1; k <= K; k++) {
                if(qList[k].isEmpty()) continue;
                
                int size = qList[k].size();
                
                for(int step = 0; step < size; step++){
                    Virus temp = qList[k].poll();
                    
                    for(int i=0; i<4; i++){
                        int nr = temp.r + deltas[i][0];
                        int nc = temp.c + deltas[i][1];
                        
                        if(isIn(nr,nc) && map[nr][nc] == 0){
                            map[nr][nc] = k;
                            qList[k].offer(new Virus(nr,nc));
                        }
                    }
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
    
    public static class Virus {
        int r, c;
        
        public Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
