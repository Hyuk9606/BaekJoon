import java.util.*;

class Solution {
    public static Map<String,String> user = new HashMap<>();
    public static int count = 0;
    public String[] solution(String[] record) {
        String[] answer = {};
        solve(record);
        answer = print(record);
        return answer;
    }
    
    static void solve(String[] record){
        StringTokenizer st = null;
        for(String str : record){
            st = new StringTokenizer(str);
            switch(st.nextToken()){
                case "Enter":
                    addUser(st.nextToken(),st.nextToken());
                    count++;
                    break;
                case "Leave":
                    count++;
                    break;
                case "Change":
                    addUser(st.nextToken(),st.nextToken());
                    break;
            }
            
        }
        
    }
    
    static void addUser(String id, String nickname){
        user.put(id,nickname);
    }
    
    public String[] print(String[] record){
        StringTokenizer st = null;
        String[] ans = new String[count];
        int index = 0;
        for(String str : record){
            st = new StringTokenizer(str);
            switch(st.nextToken()){
                case "Enter":
                    ans[index++] = user.get(st.nextToken())+"님이 들어왔습니다.";
                    break;
                case "Leave":
                    ans[index++] = user.get(st.nextToken())+"님이 나갔습니다.";
                    break;
            }
        }
 
        return ans;
        
    }
}