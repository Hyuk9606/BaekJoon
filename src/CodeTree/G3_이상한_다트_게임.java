package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_이상한_다트_게임 {
    static int N, M, Q;
    static int x, d, k;
    static int beforeTotal;
    static int[][] circlePlate;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        circlePlate = new int[N][M];
        
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                circlePlate[n][m] = Integer.parseInt(st.nextToken());
                beforeTotal += circlePlate[n][m];
            }
        }
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            rotate(x,d,k);

            
        }
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = circlePlate[i].clone();
        }
        checkRound(temp);
        System.out.println(normalization());
    }
    
    static void rotate(int X, int D, int K) {
        if (D == 0) D = -1;
        
        for (int i = 1; X * i <= M; i++) {
            int[] temp = new int[M];
            int start = K * D + M;
            for (int m = 0; m < M; m++) {
                temp[m] = circlePlate[x * i - 1][(start + m) % M];
            }
            circlePlate[x*i-1] = temp;
        }
    }
    
    static void checkRound(int[][] tempPlate){
        for (int n = 0; n < N; n++) {
            for (int m = M; m/M < 2; m++) {
//                if(circlePlate[n][(m-2)%M] == circlePlate[n][(m-1)%M]){
//                    tempPlate[n][(m-2)%M] = 0;
//                    tempPlate[n][(m-1)%M] = 0;
//                }
                if(circlePlate[n][(m-1)%M] == circlePlate[n][m%M]){
                    tempPlate[n][(m-1)%M] = 0;
                    tempPlate[n][m%M] = 0;
                }
            }
        }
        checkCross(tempPlate);
    }
    

    static void checkCross(int[][] tempPlate){
        int total = 0;
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N-1; n++) {
                if(circlePlate[n][m] == circlePlate[n+1][m]){
                    tempPlate[n][m] = 0;
                    tempPlate[n+1][m] = 0;
                }
            }
        }
        circlePlate = tempPlate;
    }
    
    static int normalization(){
        int total=0;
        int cnt = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if(circlePlate[n][m] >0){
                    total += circlePlate[n][m];
                    cnt++;
                }
            }
        }
        if(beforeTotal != total) return total;
        
        int average = total / cnt;
        beforeTotal = total;
    
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if(circlePlate[n][m] == 0) continue;
                
                if(circlePlate[n][m] > average) {
                    circlePlate[n][m]--;
                    total--;
                }
                else if (circlePlate[n][m] < average){
                    circlePlate[n][m]++;
                    total++;
                }
            }
        }
        return total;
    }
}