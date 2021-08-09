package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_1228 {
	static int T = 10;
	static int N;
	static List<String> data;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			for (int t = 1; t <= T; t++) {
				N = Integer.parseInt(br.readLine());
				data = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					data.add(st.nextToken());
				}
				N = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					st.nextToken();
					int i = Integer.parseInt(st.nextToken());
					int k = Integer.parseInt(st.nextToken());
					for (int j = 0; j < k; j++) {
						data.add(i++, st.nextToken());
					}
				}
				
				sb.append("#").append(t).append(" ");
				for (int i = 0; i < 10; i++) {
					sb.append(data.get(i)).append(" ");
				}
				sb.append("\n");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sb);
	}
}
