class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0L;
        
        for(int i=1; i<= count; i++){
            answer += (long)price * i;
        }
        answer-= money;
        if(answer < 0) answer = 0;
        
        return answer;
    }
}