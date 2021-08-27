package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B1_3985 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		boolean[] cake = new boolean[L + 1];
		N = Integer.parseInt(br.readLine());
		int ans2 = 0, ans1 = 0;
		int num1 =0, num2=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(ans2 < e-s+1) {
				ans2 = e-s+1;
				num2 = i+1;
			}
			int cnt=0;
			for (int j = s; j <= e; j++) {
				if (cake[j] == false) {
					cake[j] = true;
					cnt++;
				}
				if(cnt > ans1) {
					ans1 = cnt;
					num1 = i+1;
				}
				
			}

		}
		System.out.println(num2);
		System.out.println(num1);

	}
}
