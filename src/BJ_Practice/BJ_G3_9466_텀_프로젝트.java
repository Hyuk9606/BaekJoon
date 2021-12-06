package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G3_9466_텀_프로젝트 {
	static int T;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int [] data = new int[N+1];
			int [] check = new int[N+1];
			Arrays.fill(check, -1);
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N ; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N ; i++) {
				int cnt = 0;
				int step = i;
				while(check[step] == -1) {
					check[step] = cnt++;
					step = data[step];
					if(check[step] != -1)
						System.out.println(step+" "+(cnt - data[step]));
				}
			}
			System.out.println(Arrays.toString(check));
			
		}
	}
}
