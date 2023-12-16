package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_1874_스택_수열 {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        boolean[] isStacked = new boolean[N+1];
        
        for (int i = 0; i < N; i++) {
            int current = 0;
            if(!stack.isEmpty()) {
                current = stack.peek();
            }else{
                for (int j = 1; j <= N; j++) {
                    if(!isStacked[j]){
                        stack.push(j);
                        sb.append("+").append("\n");
                        current = j;
                        break;
                    }
                }
            }
            int target = Integer.parseInt(br.readLine());
            
            while(target > current){
                if(isStacked[++current]) continue;
                stack.push(current);
                sb.append("+").append("\n");
            }
            if(current == target){
                sb.append("-").append("\n");
                isStacked[stack.pop()] = true;
                continue;
            }
            System.out.println("NO");
            return;
        }
        System.out.println(sb.toString());
    }
}
