package BJ_Practice;

import java.io.*;

public class BJ_G5_1038 {

	static int N;

	static boolean check(long num) {
		String str = String.valueOf(num);

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) <= str.charAt(i + 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		long i = 0;
		if (N > 1022)
			sb.append(-1);
		else {
			while (N >= 0) {
				if (check(i)) {
					if (N-- == 0)
						sb.append(i);
				} else if(i%10 != 0) {
					i += 10 - (i % 10)-1;
				}
				
				i++;
			}
		}
		System.out.println(sb);

	}

}
