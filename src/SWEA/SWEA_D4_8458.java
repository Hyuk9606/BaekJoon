package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_8458 {
	static int T, N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int max = 0, check = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int number1 = Integer.parseInt(st.nextToken());
				int number2 = Integer.parseInt(st.nextToken());
				int sum = Math.abs(number1) + Math.abs(number2);
				check += sum % 2;
				max = Math.max(sum, max);
			}

			if (0 < check && check < N) {
				sb.append("#").append(t).append(" ").append(-1).append("\n");
				continue;
			}

			int step = 1;
			while (max > 0) {
				max -= step++;
			}

			max = Math.abs(max);
			if (max % 2 == 1) {
				if ((step - 1) % 2 == 0) {
					step += 1;
				} else
					step += 2;
			}

			sb.append("#").append(t).append(" ").append(step - 1).append("\n");

		}
		System.out.println(sb);
	}
}


