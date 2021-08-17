package BJ_Practice.Bronze;

import java.io.*;

public class BJ_B1_2839 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int val1 = n / 5;
			int val2 = n % 5;
			int val3 = val2 / 3;
			int val4 = val2 % 3;
			while (val4 != 0) {
				val2 += 5;
				val1--;
				val3 = val2 / 3;
				val4 = val2 % 3;
			}
			if( val1 == -1) System.out.println(-1);
			else System.out.println(val1 + val3);
		} catch (Exception e) {
		}
	}
}
