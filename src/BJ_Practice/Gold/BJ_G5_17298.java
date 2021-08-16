package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_17298 {
	static int N;
	static int[] A;
	static int[] answer;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		answer = new int[N];
		Arrays.fill(answer, -1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		stack.push(0);
		for (int i = 1; i < N; i++) {
			if (A[stack.peek()] >= A[i])
				stack.push(i);
			else {
				while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
					answer[stack.pop()] = A[i];
				}
				stack.push(i);
			}
		}
		for (int i = 0; i < N ; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}
