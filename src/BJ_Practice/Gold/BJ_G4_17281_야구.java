package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_17281_야구 {
    static int N;
    static int answer;
    static int[][] scoreArr;
    static int[] numbers;
    static boolean[] selected;
    
    public static void main(String[] args) {
        input();
        permutation(0);
        System.out.println(answer);
    }
    
    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            scoreArr = new int[N][9];
            numbers = new int[9];
            selected = new boolean[9];
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 9; i++) {
                    scoreArr[n][i] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void permutation(int cnt) {
        if (cnt == 9) {
            if (numbers[3] == 0) {
                answer = Math.max(play(), answer);
            }
            return;
        }
        
        for (int i = 0; i < 9; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            numbers[cnt] = i;
            permutation(cnt + 1);
            selected[i] = false;
        }
    }
    
    static int play() {
        int score = 0;
        int curNum = 0;
        for (int n = 0; n < N; n++) {
            int outCount = 0;
            int result = 0;
            boolean[] ground = new boolean[4];
            while (outCount < 3) {
                int curResult = scoreArr[n][numbers[curNum++]];
                if (curNum == 9) curNum %= 9;
                if (curResult == 0) outCount++;
                else if (curResult < 4) {
                    for (int g = 3; g >= 1; g--) {
                        if (ground[g]) {
                            ground[g] = false;
                            if (g + curResult > 3) {
                                result++;
                            } else {
                                ground[g + curResult] = true;
                            }
                        }
                    }
                    ground[curResult] = true;
                } else {
                    for (int g = 1; g <= 3; g++) {
                        if (ground[g]) {
                            result++;
                            ground[g] = false;
                        }
                    }
                    result++;
                }
            }
            score += result;
        }
        return score;
    }
}
