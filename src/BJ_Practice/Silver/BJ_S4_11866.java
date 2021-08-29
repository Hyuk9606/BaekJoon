package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_11866 {
	static int N, K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		int i = 1;
		sb.append("<");
		while (!queue.isEmpty()) {
			if (i++ % K == 0) {
				sb.append(queue.poll());
				if (queue.isEmpty()) {
					sb.append(">");
					break;
				}
				sb.append(", ");
			} else
				queue.offer(queue.poll());
		}
		System.out.println(sb);
	}
}
