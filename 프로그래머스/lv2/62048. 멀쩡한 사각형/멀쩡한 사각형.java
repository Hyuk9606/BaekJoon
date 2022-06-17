import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long gcd = 0;
        long cut = 0;
        
        if(w > h)
            gcd = gcd(w,h);
        else gcd = gcd(h,w);
        
        cut = w + h - gcd;
        
        answer = (long)w * h - cut;
        
        return answer;
    }
    
    public static long gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return Math.abs(a);
    }
}