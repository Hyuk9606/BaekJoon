package BJ_Practice.Unknown;

import java.io.*;

public class BJ_10808 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			char[] str = br.readLine().toCharArray();
			int[] num = new int[26];
			for (int i = 0; i < str.length; i++) {
				num[str[i] - 'a']++;
			}

			for (int i = 0; i < 26; i++)
				System.out.printf("%d ", num[i]);
		} catch (Exception e) {
		}

	}
}
