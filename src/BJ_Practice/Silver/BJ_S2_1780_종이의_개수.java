package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_1780_종이의_개수 {
    static int N;
    static int[][] map;
    static int[] answer = new int[3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        findSameNumber(map, N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }
    
    static void findSameNumber(int[][] map, int size) {
        int number = map[0][0];
        boolean isDivided = false;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (map[r][c] == number) continue;
                divide(map, size);
                isDivided = true;
                return;
            }
        }
        if (!isDivided) answer[number + 1] += 1;
    }
    
    static void divide(int[][] map, int size) {
        int newSize = size / 3;
        int[][] tempMap = new int[newSize][newSize];
        for (int i = 0; i < size; i += newSize) {
            for (int j = 0; j < size; j += newSize) {
                
                for (int r = 0; r < newSize; r++) {
                    for (int c = 0; c < newSize; c++) {
                        
                        tempMap[r][c] = map[r + i][c + j];
                        
                    }
                }
                findSameNumber(tempMap, newSize);
            }
        }
    }
}
