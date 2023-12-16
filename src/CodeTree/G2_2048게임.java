package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class G2_2048게임 {
    static int N;
    static int[][] map;
    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
    
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }
    static void move(int dir, int[][] tempMap){
        for (int r = 0; r < N; r++) {
            tempMap[r] = map[r].clone();
        }
        
        if(dir == 0){
            int tempR = N-1;
            for (int c = 0; c < N; c++) {
                for (int r = N-1; r > 0; r--)  {
                    if(map[r][c] == 0) continue;
                    tempMap[tempR][c] = map[r][c];
                }
            }
            
            for (int c = 0; c < N; c++) {
                for (int r = N-1; r > 0; r--) {
                    if(tempMap[r][c] != 0 && tempMap[r][c] == tempMap[r-1][c]){
                        tempMap[r][c] *= 2;
                        tempMap[r-1][c] = 0;
                    }
                }
                
            }
        }
        
    }
}
