package programmers;

import java.util.*;

class LV2_행렬_테두리_회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arrays = new int[rows + 1][columns + 1];
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arrays[i][j] = count++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            answer[i] = ratate(arrays, queries[i]);
        }
        return answer;
    }
    
    public int ratate(int[][] arrays, int[] queries) {
        int[][] temp = new int[arrays.length][arrays[0].length];
        
        
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                temp[i][j] = arrays[i][j];
            }
        }
        int temp_val = arrays[queries[0]][queries[1]];
        int min_val = temp_val;
        for (int r = queries[0]; r < queries[2]; r++) {
            temp[r][queries[1]] = arrays[r + 1][queries[1]];
            min_val = Math.min(min_val, arrays[r + 1][queries[1]]);
        }
        
        for (int c = queries[1]; c < queries[3]; c++) {
            temp[queries[2]][c] = arrays[queries[2]][c + 1];
            min_val = Math.min(min_val, arrays[queries[2]][c + 1]);
        }
        
        for (int r = queries[2]; r > queries[0]; r--) {
            temp[r][queries[3]] = arrays[r - 1][queries[3]];
            min_val = Math.min(min_val, arrays[r - 1][queries[3]]);
        }
        
        for (int c = queries[3]; c > queries[1]; c--) {
            temp[queries[0]][c] = arrays[queries[0]][c - 1];
            min_val = Math.min(min_val, arrays[queries[0]][c - 1]);
        }
        temp[queries[0]][queries[1] + 1] = temp_val;
        
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                arrays[i][j] = temp[i][j];
            }
        }
        
        return min_val;
    }
}