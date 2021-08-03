package SWEA;

import java.io.*;

public class SWEA_D3_1289 {
	private static int N;

	private static int restore(String str) {
		int cnt = 0;
		char[] c = str.toCharArray();
		char num = '0';
		for (int i = 0; i < c.length; i++) {
			if (c[i] != num) {
				if (num == '0')
					num = '1';
				else
					num = '0';
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				sb.append("#").append(i + 1).append(" ").append(restore(br.readLine())).append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
		}

	}
}
