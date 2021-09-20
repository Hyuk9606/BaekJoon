package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_2609 {
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	 
	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	static int N,M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(gcd(N,M));
		System.out.println(lcm(N,M));
	}
}
