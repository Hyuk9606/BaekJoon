import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< progresses.length; i++){
            progresses[i] = 100 - progresses[i];
            int result = progresses[i] / speeds[i];
            if((progresses[i] % speeds[i]) > 0){
                result++;
            }
            progresses[i] = result;
        }
        
        int current = progresses[0];
        int index = 0;
        for(int i=1; i< progresses.length; i++){
            if(current >= progresses[i]) continue;
            queue.offer(i - index);
            current = progresses[i];
            index = i;
        }
        
        queue.offer(progresses.length - index);
        
        answer = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty())
            answer[i++] = queue.poll();
        
        return answer;
    }
}