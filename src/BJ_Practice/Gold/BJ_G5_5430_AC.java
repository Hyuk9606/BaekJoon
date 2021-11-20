package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_5430_AC {
	static int T;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		outer: for (int t = 1; t <= T; t++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String array = br.readLine();
			array = array.substring(1, array.length() - 1);
			String[] strs = array.split(",");
			int curr = 0;
			int[] point = new int[2];
			point[0] = 0;
			point[1] = N - 1;
			for (int i = 0; i < command.length(); i++) {
				char cmd = command.charAt(i);

				if (cmd == 'R') {
					curr++;
					curr %= 2;
				} else {
					if (curr == 0)
						point[0]++;
					else
						point[1]--;
				}

				if (point[0] > point[1]+1) {
					sb.append("error\n");
					continue outer;
				}
			}
			if (curr == 0) {
				sb.append("[");
				for (int i = point[0]; i <= point[1]; i++) {
					sb.append(strs[i]);
					if (i != point[1])
						sb.append(",");
				}
				sb.append("]\n");
			} else {
				sb.append("[");
				for (int i = point[1]; i >= point[0]; i--) {
					sb.append(strs[i]);
					if (i != point[0])
						sb.append(",");
				}
				sb.append("]\n");
			}
		}
		System.out.print(sb.toString());
	}
}
