import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        new_id = level1(new_id);      
        new_id = level2(new_id);      
        new_id = level3(new_id);
        new_id = level4AndLelel5(new_id);
        new_id = level6(new_id);
        new_id = level7(new_id);
        answer = new_id;
        
        return answer;
    }
    
    public String level1(String id){
        id = id.toLowerCase();
        return id;
    }
    
    public String level2(String id){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< id.length(); i++){
            if(check(id.charAt(i))){
                sb.append(id.charAt(i));
            }
        }        
        if(sb.toString().length() == 0) return "a";
        return sb.toString();
    }
    
    
    public boolean check(char c){
        if('a' <= c && c <= 'z')
            return true;
        if('0' <= c && c <= '9')
            return true;
        if(c == '-' || c == '_' || c == '.')
            return true;
        
        return false;
    }
    
    public String level3(String id){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < id.length(); i++){
            if(id.charAt(i) != '.')
                sb.append(id.charAt(i));
            else if(i != id.length()-1 && id.charAt(i) == '.' && id.charAt(i+1) != '.')
                sb.append(".");
            else if(i == id.length()-1 && id.charAt(i) == '.')
                sb.append(".");            
        }
        if(sb.toString().length() == 0) return "a";
        return sb.toString();
    }
    
    public String level4AndLelel5(String id){
        try{
            if(id.startsWith("."))
                id = id.substring(1,id.length());
            if(id.endsWith("."))
                id = id.substring(0,id.length()-1);
            
            if(id.length() == 0) throw new Exception();
            return id;
        }catch(Exception e){
            return "a";
        }
    }
    
    public String level6(String id){
        if(id.length() >= 16){
            id = id.substring(0,15);
            if(id.endsWith("."))
                id = id.substring(0,14);
        }
        return id;
    }
    
    public String level7(String id){
        while(id.length() <= 2){
            id += id.charAt(id.length()-1);
        }
        return id;
    }
}