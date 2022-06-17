import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int len = 1; len <= s.length() / 2; len++){
            int cnt = 1;
            String result = "";
            String substr = s.substring(0,len);
            for(int i = len; i < s.length(); i += len){
                if(i+len <= s.length()){
                    if(s.substring(i,i+len).equals(substr)){
                        cnt++;
                    }else{
                        if(cnt != 1)
                            result+= Integer.toString(cnt,10);
                        result+= substr;
                        // System.out.print(Integer.toString(cnt) + substr);
                        substr = s.substring(i,i+len);
                        cnt = 1;
                    }
                }
                    
                if(i+len >= s.length()){
                    if(cnt != 1)
                        result+= Integer.toString(cnt,10);
                    result+= substr;
                    // System.out.print(Integer.toString(cnt) + substr);
                    if(i+len != s.length()) 
                        result+= s.substring(i,s.length());
                }
            }
            // System.out.println();
            // System.out.println(result);
            answer = Math.min(answer,result.length());
        }
        return answer;
    }
}