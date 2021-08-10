package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_1158 {
	static int N, K;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				q.offer(i);
			}
			sb.append("<");
			while (!q.isEmpty()) {
				for (int i = 0; i < K-1; i++)
					q.offer(q.poll());
				sb.append(q.poll()).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append(">");
			System.out.println(sb);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
