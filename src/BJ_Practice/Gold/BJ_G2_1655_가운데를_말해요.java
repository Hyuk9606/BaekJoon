package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_G2_1655_가운데를_말해요 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        N = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        maxPQ.offer(mid);
        sb.append(mid);
        for (int i = 2; i <= N; i++) {
            sb.append("\n");
            int num = Integer.parseInt(br.readLine());
            if(maxPQ.size() > minPQ.size()){
                minPQ.offer(num);
            }else{
                maxPQ.offer(num);
            }

            if(maxPQ.peek() > minPQ.peek()){
                int max = maxPQ.poll();
                int min = minPQ.poll();
                maxPQ.offer(min);
                minPQ.offer(max);
            }

            sb.append(maxPQ.peek());
        }
        System.out.println(sb.toString());
    }
}
