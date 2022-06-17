import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board[0].length;
        Stack<Integer>[] crains = new Stack[size];
        for(int i=0; i < size; i++){
            crains[i] = new Stack<>();
        }
        
        for(int c = 0; c < size; c++){
            for(int r = size-1; r >= 0; r--){
                if(board[r][c] != 0){
                    crains[c].push(board[r][c]);
                }
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves){
            if(crains[move-1].isEmpty()) continue;
            int num = crains[move-1].pop();
            if(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                answer+= 2;
            }
            else{
                stack.push(num);
            }
        }
       
        
        return answer;
    }
}