import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] arr = new int[commands[i][1] - commands[i][0] + 1];
            for(int k = 0; k < arr.length; k++){
                arr[k] = array[commands[i][0]+k-1];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        
        return answer;
    }
}