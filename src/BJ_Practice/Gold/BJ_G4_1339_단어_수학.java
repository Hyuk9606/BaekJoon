package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_G4_1339_단어_수학 {
    static int N, maxLen = 0;
    static int Answer = 0;
    static int cntNum;
    static int[] numbers;
    static boolean[] isSelected;
    static String[] data;
    static char[][] dataChecker;
    static int[] alphabet = new int[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        data = new String[N];
        Arrays.fill(alphabet, -1);
        
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine();
            maxLen = Math.max(maxLen, data[i].length());
        }
        
        dataChecker = new char[N][maxLen];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                dataChecker[i][maxLen - data[i].length() + j] = data[i].charAt(j);
                alphabet[data[i].charAt(j) - 'A'] = 0;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != -1) cntNum++;
        }
        numbers = new int[cntNum];
        isSelected = new boolean[10];
        permutation(0);
        
        System.out.println(Answer);
    }
    
    static void permutation(int cnt) {
        if (cnt == cntNum) {
            check();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += makeNumber(dataChecker[i]);
            }
            Answer = Math.max(Answer, sum);
            return;
        }
        
        for (int i = 9; i >= 10-cntNum; i--) {
            if (isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
    
    static void check() {
        int index = 0;
        Arrays.fill(alphabet, -1);
        for (int j = 0; j < maxLen; j++) {
            for (int i = 0; i < N; i++) {
                if (dataChecker[i][j] == '\u0000') continue;
                if (alphabet[dataChecker[i][j] - 'A'] != -1) continue;
                alphabet[dataChecker[i][j] - 'A'] = numbers[index++];
            }
        }
    }
    
    static int makeNumber(char[] dataChecker) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            if (dataChecker[i] == '\u0000') continue;
            number.append(alphabet[dataChecker[i] - 'A']);
        }
        return Integer.parseInt(number.toString());
    }
}