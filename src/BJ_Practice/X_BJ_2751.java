package BJ_Practice;

import java.io.*;

public class X_BJ_2751 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int N = Integer.parseInt(br.readLine());

			int[] cnt = new int[2000001];

			for (int i = 0; i < N; i++)
				cnt[Integer.parseInt(br.readLine())+1000000]++;

			for (int i = 0; i < 2000001; i++) {
				for (int j = 0; j < cnt[i]; j++) {
					bw.write(Integer.valueOf(i-1000000) + "\n");
				}
				bw.flush();

			}
			bw.close();
			br.close();
		} catch (Exception e) {
		}
	}
}
