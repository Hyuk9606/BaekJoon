package BJ_Practice.Silver;

import java.io.*;
import java.math.*;
import java.util.*;

public class BJ_S3_2407 {
	static int N,M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		BigInteger a = new BigInteger("1");

		long K = N;
		for (int i = 0; i < M ; i++) {
			a = a.multiply(BigInteger.valueOf(K--));
		}
		K = M;
		for (int i = 0; i < M ; i++) {
			a = a.divide(BigInteger.valueOf(K--));
		}
		System.out.println(a);
	}
	
}
