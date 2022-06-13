import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr){
            if(stack.isEmpty() || stack.peek() != num){
                stack.push(num);
            }
        }
        
        int[] temp = new int[stack.size()];
        answer = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty())
            temp[i++] = stack.pop();
        
        for(int j = 0; j<temp.length; j++){
            answer[j] = temp[temp.length - j -1];
        }

        return answer;
    }
}