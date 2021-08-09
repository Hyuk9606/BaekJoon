package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1940 {
	static int T, N,cur,x;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cur = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				switch (x) {
				case 1:
					cur += Integer.parseInt(st.nextToken())*(N-i);
					break;
				case 2:
					cur -= Integer.parseInt(st.nextToken())*(N-i);
					break;
				}
				if(cur < 0) cur =0;
			}
			sb.append("#").append(t).append(" ").append(cur).append("\n");
		}
		br.close();
		System.out.println(sb);
	}
}
