package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2493 {

	static int N;
	static int[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		data = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(N);
		int step = N - 1;
		while (step > 0) {
			if (data[step] < data[stack.peek()]) {
				stack.push(step--);
			} else {
				while (!stack.isEmpty() && data[stack.peek()] < data[step]) {
					data[stack.pop()] = step;
				}
				stack.push(step--);
			}

		}
		while(!stack.isEmpty()) {
			data[stack.pop()] = 0;
		}
		for(int i= 1; i<=N; i++) {
			sb.append(data[i]).append(" ");
		}
		System.out.println(sb);
	}
}
