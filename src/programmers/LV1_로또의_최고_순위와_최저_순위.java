package programmers;

import java.util.*;

class LV1_로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0)
                zero_count++;
        }
        
        int correct = check(lottos, win_nums);
        answer[0] = 7 - correct - zero_count;
        answer[1] = 7 - correct;
        
        if (zero_count == 6)
            answer[1]--;
        if (zero_count == 0 && correct == 0) {
            answer[0] = 6;
            answer[1] = 6;
        }
        
        
        return answer;
    }
    
    public int check(int[] lottos, int[] win_nums) {
        
        int check = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    check++;
                    break;
                }
            }
        }
        
        return check;
    }
}
