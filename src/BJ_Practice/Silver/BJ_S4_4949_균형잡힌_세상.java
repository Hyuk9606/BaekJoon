package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_S4_4949_균형잡힌_세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
out:
        while (true) {
            String str = br.readLine();
            if (".".equals(str)) break;
            
            Stack<Character> stack = new Stack<>();
            int len = str.length();
            
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                int type = isBracket(c);
                
                if (type == 0) {
                    continue;
                } else if (type == 1) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !compareBracket(c, stack.pop())) {
                        sb.append("no").append("\n");
                        continue out;
                    }
                }
            }
            
            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    static int isBracket(char c) {
        if (c == '[' || c == '(') {
            return 1;
        } else if (c == ']' || c == ')')
            return 2;
        
        return 0;
    }
    
    static boolean compareBracket(char close, char open) {
        if (close == ']' && open == '[')
            return true;
        if (close == ')' && open == '(')
            return true;
        
        return false;
    }
}
