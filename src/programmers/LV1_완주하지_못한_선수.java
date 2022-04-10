package programmers;

import java.util.*;

class LV1_완주하지_못한_선수 {

        public String solution(String[] participant, String[] completion) {
            String answer = "";
            count(participant);
            answer = solve(completion);
            return answer;
        }
        
        static Map<String,Integer> participants = new HashMap<>();
        
        public void count(String[] participant){
            for(String part : participant){
                participants.put(part,participants.getOrDefault(part,0)+1);
            }
        }
        
        public String solve(String[] completion){
            for(String str : completion){
                participants.put(str,participants.get(str)-1);
            }
            
            for(String str : participants.keySet()){
                if(participants.get(str) >= 1)
                    return str;
            }
            return "";
        }
    }
