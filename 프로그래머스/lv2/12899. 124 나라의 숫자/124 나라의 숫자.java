import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        System.out.print(Integer.toString(500000000,3));
        answer = Integer.toString(n,3);
        int i = 10;
        while( i-- > 0){
            answer = answer.replaceAll("10","04");
            answer = answer.replaceAll("20","14");
            answer = answer.replaceAll("40","24");
        }
        if(answer.charAt(0) == '0') answer = answer.substring(1,answer.length());

        
        // for(int i=0; i<answer.length(); i++){
        //     if(answer.charAt(i) == 0)
        // }
        
        return answer;
    }
}