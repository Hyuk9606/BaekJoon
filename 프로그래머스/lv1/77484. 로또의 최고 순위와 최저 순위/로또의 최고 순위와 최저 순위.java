import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int match = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for(int lotto : lottos){
            if(lotto == 0){
                zeroCount++;
                continue;
            }
            
            for(int win : win_nums){
                if(lotto == win) {
                    match++;
                    break;
                }
            }
        }
        
        
        if(match < 2)
            answer[1] = 6;
        else answer[1] = 7 - match ;
        
        answer[0] = answer[1] - zeroCount;
        if(answer[0] < 1) answer[0] = 1;
        
        return answer;
    }
}