package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_1629_곱셈 {
	static int A, B, C;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		

		System.out.println(power((long)A,B));
	}

	static long power(long a, int b) {
		if (b == 1)
			return a % C;

		long half = power(a, b / 2) % C;

		if (b % 2 == 0)
			return (half * half) % C;
		else
			return ((half * half)%C * a) % C;

	}
}
