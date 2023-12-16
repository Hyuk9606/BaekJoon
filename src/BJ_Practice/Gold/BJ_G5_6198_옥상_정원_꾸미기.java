package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_G5_6198_옥상_정원_꾸미기 {
    static int N;
    static long answer = 0L;
    static int[] data;
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> comp = new Stack<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N - 1; i >= 0; i--) {
            stack.push(data[i]);
        }
        
        comp.push(stack.pop());
        int current = comp.peek();
        while(!stack.isEmpty()){
            int next = stack.pop();
            if(current > next){
                answer += comp.size();
                comp.push(next);
            } else {
                while(!comp.isEmpty() && comp.peek() <= next){
                    comp.pop();
                }
                answer += comp.size();
                comp.push(next);
            }
            current = next;
        }
        System.out.println(answer);
    }
}
