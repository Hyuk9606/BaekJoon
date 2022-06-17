import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] check = new boolean[3001];
        for(int i=2; i<=3000; i++){
            if(!check[i])
                for(int j=2; j <= 3000; j++ ){
                    if(i*j > 3000) break;
                    check[i*j] = true;
                }
        }

        for(int i=0; i < nums.length-2; i++){
            for(int j=i+1; j < nums.length-1; j++){
                for(int k=j+1; k < nums.length; k++){
                    int num = nums[i]+nums[j]+nums[k];
                    if(!check[num]) answer++;
                }
            }
        }
        
        return answer;
    }
}