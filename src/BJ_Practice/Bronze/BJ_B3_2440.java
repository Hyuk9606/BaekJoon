package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B3_2440 {
	
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		while(N >= 1) {
			System.out.println(star(N--));
		}
	}
	static String star(int N) {
		String str = "";
		for (int i = 0; i < N ; i++) {
			str+= "*";
		}
		return str;
	}
}
