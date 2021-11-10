package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2812_크게만들기 {
	static int N,K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		int len = str.length();
		stack.push(str.charAt(0));
		for (int i = 1; i < len ; i++) {
			char cur = str.charAt(i);
			if(stack.peek()-'0' >= cur - '0') {
				stack.push(cur);
			}
			else{
				while(K>0 && stack.peek()-'0' < cur -'0') {
					stack.pop();
					K--;
					if(stack.isEmpty()) break;
				}
				stack.push(cur);
			}
		}
		for (int i = 0; i < K ; i++) {
			stack.pop();
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();
		System.out.println(sb);
	}
}
