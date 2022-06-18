import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(reserve[i] == lost[j]){
                    lost[j] = -100;
                    reserve[i] = -10;
                    answer++;
                    break;
                }
            }
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int res : reserve){
            for(int l = 0; l < lost.length; l++){
                if(lost[l] == res-1 || lost[l] == res+1){
                    answer++;
                    lost[l] = 0;
                    break;
                }
            }
        }
        
        answer += n - lost.length;
        System.out.println(Arrays.toString(lost));
        
        return answer;
    }
}