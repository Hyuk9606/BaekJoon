package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_20437_문자열_게임2 {

	static int T, K;
	static String W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayList<Integer>[] lists = new ArrayList[26];
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 26; j++) {
				lists[j] = new ArrayList<>();
				lists[j].add(0);
			}
			W = br.readLine();
			K = Integer.parseInt(br.readLine());
			for (int j = 0; j < W.length(); j++) {
				int idx = W.charAt(j) - 'a';
				lists[idx].add(j);
			}
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int idx = 0; idx < 26; idx++) {
				if (lists[idx].size() <= K) {
					continue;
				}

				for (int j = K; j < lists[idx].size(); j++) {
					min = Math.min(min, lists[idx].get(j) - lists[idx].get(j - K + 1) + 1);
					max = Math.max(max, lists[idx].get(j) - lists[idx].get(j - K + 1) + 1);
				}
			}
			if (min != Integer.MAX_VALUE)
				sb.append(min).append(" ").append(max).append("\n");
			else sb.append("-1").append("\n");
		}
		System.out.println(sb.toString());
	}
}
