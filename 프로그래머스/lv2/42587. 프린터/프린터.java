import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] arr = new int[10];
        Queue<Docs> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            arr[priorities[i]]++;
            queue.offer(new Docs(i,priorities[i]));
        }
        
        for(int i=9; i>0; i--){
            while(arr[i] > 0){
                Docs temp = queue.poll();

                if(temp.prior < i) queue.offer(temp);
                else if(temp.no == location) {
                    answer++;
                    return answer;
                }
                else {
                    arr[i]--;
                    answer++;
                }
                
            }
        }
        
        return answer;
    }
    
    public class Docs{
        int no;
        int prior;
        
        public Docs(int no, int prior){
            this.no = no;
            this.prior = prior;
        }
    }
}