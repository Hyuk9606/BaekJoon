import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] stageArr = new Stage[N+2];
        stageArr[0] = new Stage(0);
        stageArr[0].fail = -100.0f;
        for(int i=1; i<=N+1 ; i++){
            stageArr[i] = new Stage(i);
        }
        
        for(int stage : stages){
            stageArr[stage].user++;
        }
        
        int total = stageArr[N+1].user;
        
        for(int i= N; i > 0 ; i--){
            total += stageArr[i].user;
            if(total == 0) continue;
            stageArr[i].fail = stageArr[i].user / (float)total;
        }
        
        Arrays.sort(stageArr,(o1,o2)->Float.compare(o2.fail,o1.fail));
        
        for(int i=0; i<N; i++){
            answer[i] = stageArr[i].no;
        }
        
        return answer;
    }
    
    public class Stage{
        int no;
        int user;
        float fail;
        
        public Stage(int no){
            this.no = no;
            this.user = 0;
            this.fail = 0.0f;
        }
    }
}