package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_9252_LCS2 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s1 = br.readLine();
		String s2 = br.readLine();

		int[][] lcs = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		if (lcs[s1.length()][s2.length()] == 0) {
			System.out.println(0);
		} else {
			int i = s1.length();
			int j = s2.length();
			System.out.println(lcs[s1.length()][j]);
			while (i > 0 && j > 0) {
				if (lcs[i][j] == lcs[i - 1][j])
					i--;
				else if (lcs[i][j] == lcs[i][j - 1])
					j--;
				else {
					sb.append(s1.charAt(i - 1));
					i--;
					j--;
				}
			}
		}
		System.out.println(sb.reverse().toString());
	}
}