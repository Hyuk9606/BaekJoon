package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_3499 {

	static int T;
	static int N;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<String> Q1;
		Queue<String> Q2;

		try {
			T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				N = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());

				Q1 = new LinkedList<>();
				Q2 = new LinkedList<>();
				
				for(int i=0; i<(N/2)+(N%2);i++) {
					Q1.offer(st.nextToken());
				}
				while (st.hasMoreTokens()) {
					Q2.offer(st.nextToken());
				}
				sb.append("#").append(t).append(" ");
				while (!Q2.isEmpty()) {
					sb.append(Q1.poll()).append(" ").append(Q2.poll()).append(" ");
				}
				if (!Q1.isEmpty())
					sb.append(Q1.poll());
				sb.append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
		}

	}
}
