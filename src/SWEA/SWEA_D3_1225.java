package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_1225 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int value;
			int x = 1;
			do {
				value = queue.poll();
				value = Integer.max(value - x, 0);
				x++;
				if (x == 6)
					x = 1;
				queue.offer(value);
			} while (value > 0);

			sb.append("#").append(T).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
