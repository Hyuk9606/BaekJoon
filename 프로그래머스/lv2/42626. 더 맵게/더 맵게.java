import java.util.*;

class Solution {
    public static PriorityQueue<Long> pq;
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        pq = new PriorityQueue<>();
        for(int scov : scoville) pq.offer((long)scov);
        
        while(true){
            int res = mix(K);
            if(res == -1){
                answer = -1;
                break;
            }else if(res == 0){
                break;
            }else if(res == 2){
                answer++;
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    public int mix(int K){
        if(pq.size() < 2)
            return -1;
        long min = pq.poll();
        long second = pq.poll();
        
        if(min >= K) return 0;
        
        if(pq.size() == 0 && min+(second*2)>=K) return 2;
        
        pq.offer(min+(second*2));
        return 1;
    }
}