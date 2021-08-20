package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_1223 {
	static int T, N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Object> list = new ArrayList<>();
		Stack<Character> stack = new Stack<>();

		T = 10;

		for (int t = 1; t <= T; t++) {
			list.clear();
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();

//			System.out.println(str.substring(1,2));
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if (c - '0' >= 0) {
					list.add(c);
				} else {
					if (stack.isEmpty()) {
						stack.push(c);
					} else if (c == '*' || c == '/')
						stack.push(c);
					else {
						if (stack.peek() == '*' || stack.peek() == '/') {
							while (!stack.isEmpty())
								list.add(stack.pop());
						}
						stack.push(c);
					}
				}
			}
			while (!stack.isEmpty())
				list.add(stack.pop());
			
			int i=1;
			Stack<Integer> number = new Stack<>();
			for (Object obj : list) {
				
				if((char)obj - '0' >= 0) {
					int num = (char)obj-'0';
					number.push(num);
					
				} else {
					
					int y = number.pop();
					int x = number.pop();

					char oper = (char) obj;
					switch (oper) {
					case '*':
						number.push(x * y);
						break;
					case '/':
						number.push(x / y);
						break;
					case '+':
						number.push(x + y);
						break;
					case '-':
						number.push(x - y);
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(number.pop()).append("\n");

		}
		System.out.println(sb);

	}

}
