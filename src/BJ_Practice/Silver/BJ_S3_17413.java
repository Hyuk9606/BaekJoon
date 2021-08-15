package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_17413 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char c;
		String str = br.readLine();
		boolean flag = false;
		
		for(int i=0; i<str.length(); i++) {
			c = str.charAt(i);
			if(c == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
				flag = true;
				continue;
			}
			else if(c == '>') {
				sb.append(c);
				flag = false;
				continue;
			}
			if(c == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
				continue;
			}
			if(flag == true) {
				sb.append(c);
				
			}
			else {
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
		
		
		
	}
}
