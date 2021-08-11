package SWEA;

import java.io.*;
import java.util.*;

/**
 * @author THKim
 */

public class X_SWEA_D4_1233 {

	static int N;
	static String[] data;
	static int Answer;
	static String oper = "*+/-";

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		try {
			N = Integer.parseInt(br.readLine());
			data = new String[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				data[i] = st.nextToken();
			}
			Answer = 1;
			postOrder(1);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static void postOrder(int parent) {
		if (parent > N)
			return;

		postOrder(parent * 2);
		postOrder((parent * 2) + 1);

		String node = data[parent];
		if (oper.contains(node)) {
			if (parent * 2 > N || parent * 2 + 1 > N) {
				Answer = 0;
				return;

			} else {
				String left = data[parent * 2];
				String right = data[parent * 2 + 1];
				if (oper.contains(left) || oper.contains(right)) {
					Answer = 0;
					return;
				}
				data[parent] = "0";

			}
		}

	}

}
