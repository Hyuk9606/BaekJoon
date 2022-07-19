import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] check = new boolean[101];
    static int answer = Integer.MAX_VALUE;
    static Map<Integer,Integer> ladders = new HashMap<>();
    static Map<Integer,Integer> snakes = new HashMap<>();
    public static void main(String[] args) {
        input();
        solve();
        System.out.println(answer);
    }
    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                ladders.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            for(int m = 0; m < M; m++){
                st = new StringTokenizer(br.readLine());
                snakes.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    static void solve(){
        PriorityQueue<Player> pq = new PriorityQueue<>((p1,p2)->{
            if(p1.count == p2.count)
                return Integer.compare(p2.num,p1.num);
            return Integer.compare(p1.count, p2.count);
        });
        pq.offer(new Player(1,0));
        
        while(!pq.isEmpty()){
            Player temp = pq.poll();
            if(temp.num == 100){
                answer = Math.min(answer, temp.count);
                return;
            }
            
            for(int i=6; i>0; i--){
                int num = temp.num+i;
                if(num > 100||check[num] ) continue;
                if(ladders.containsKey(num)){
                    pq.offer(new Player(ladders.get(num),temp.count+1));
                    check[ladders.get(num)] = true;
                }else if(snakes.containsKey(num)){
                    pq.offer(new Player(snakes.get(num),temp.count+1));
                    check[snakes.get(num)] = true;
                }else {
                    pq.offer(new Player(num, temp.count + 1));
                }
                check[num] = true;
            }
        }
    }
    
    static class Player{
        int num;
        int count;
    
        public Player(int num, int count) {
            this.num = num;
            this.count = count;
        }
    
        @Override
        public String toString() {
            return "Player{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }
}