package BJ_Practice.Gold;

import java.io.*;

public class BJ_G5_15927 {

	static char[] c;
	static int max = 0;

	public static boolean check(int s, int e) {
		if (s >= e)
			return true;

		else {
			if (c[s] == c[e]) {
				return check(s + 1, e - 1);
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = br.readLine().toCharArray();
		max = c.length;
		int s = 0;
		int e = c.length - 1;
		if (check(s, e)) {
			max = e;
			for (int i = 0; i <= max; i++)
				if (c[0] == c[i]) {
					if (i == c.length - 1) {
						max = -1;
						break;
					}
				}else break;

		} else
			max = c.length;
		System.out.println(max);

	}
}
