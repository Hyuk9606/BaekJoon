package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S2_24040_예쁜_케이크 {

	static int T;
	static long N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Long.parseLong(br.readLine());
			if (N % 3 == 2 || N % 9 == 0)
				System.out.println("TAK");
			else
				System.out.println("NIE");
		}
	}
}
