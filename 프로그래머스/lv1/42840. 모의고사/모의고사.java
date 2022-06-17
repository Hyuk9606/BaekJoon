import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        Ans[] answer = new Ans[3];
        answer[0] = new Ans(1,0);
        answer[1] = new Ans(2,0);
        answer[2] = new Ans(3,0);
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i<answers.length; i++){
            int ans = answers[i];
            answer[0].cnt += ans == first[i%first.length] ? 1 : 0;
            answer[1].cnt += ans == second[i%second.length] ? 1 : 0;
            answer[2].cnt += ans == third[i%third.length] ? 1 : 0;
        }
        
        int max = Math.max(answer[0].cnt, Math.max(answer[1].cnt, answer[2].cnt));
        
        int count = 0;
        for(int i=0; i<3; i++){
            System.out.println(answer[i].cnt);
            if(answer[i].cnt == max)
                count++;
        }
        
        Arrays.sort(answer, (o1, o2)->{
            if(o1.cnt == o2.cnt) return Integer.compare(o1.num,o2.num);
                return Integer.compare(o2.cnt,o1.cnt);
        });
        
        int[] a = new int[count];
        
        for(int i=0; i<count; i++){
            a[i] = answer[i].num;
        }
        
        return a;
    }
    
    public class Ans{
        int num;
        int cnt;
        
        public Ans(int n, int c){
            num = n;
            cnt = c;
        }
    }
}