package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_1107_리모컨 {
	static int N, M;
	static int len, answer = 500001;
	static boolean[] wrong = new boolean[10];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		len = str.length();
		N = Integer.parseInt(str);
		M = Integer.parseInt(br.readLine());

		if (M != 0)
			st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			wrong[Integer.parseInt(st.nextToken())] = true;
		}
		if(M != 10)
			for (int i = 9; i >=0 ; i--) {
				if(!wrong[i]) {
					comb(0, 9, i);
					break;
				}
			}
		answer = Math.min(answer, (Math.abs(100-N)));
		System.out.println(answer);
	}

	static void comb(int cnt, int start, int num) {
		answer = Math.min(answer, (Math.abs(num - N) + String.valueOf(num).length()));
		if (cnt == len+1) {
//			System.out.println(num);
			return;
		}

		for (int i = 9; i >= 0; i--) {
			if (wrong[i])
				continue;
			
			if (cnt == 0) {
//				answer = Math.min(answer, (Math.abs(num - N) + String.valueOf(num).length()));
				num = i;
				comb(cnt + 1, i, num);
			} else {
//				answer = Math.min(answer, (Math.abs(num*10+i - N) + String.valueOf(num).length()));
				comb(cnt + 1, i, num * 10 + i);
			}
		}
	}
}
