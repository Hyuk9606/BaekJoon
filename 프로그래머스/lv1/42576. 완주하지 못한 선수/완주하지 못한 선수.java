import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> result = new HashMap<>();
        for(String runner : participant){
            int count = result.getOrDefault(runner,0);
            result.put(runner,count+1);
        }
        
        for(String goal : completion){
            result.put(goal,result.get(goal)-1);
        }
        
        for(Map.Entry<String,Integer> e : result.entrySet()){
            if(e.getValue() > 0){
                answer = e.getKey();
                break;
            }
        }
        
        return answer;
    }
}