package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G1_11401 {
	static int N, M;
	static int MOD = 1_000_000_007;
	static long num1,num2,num3;
	static long[] fac;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fac(N);
		num1 = fac[N];
		num2 = fac[N-M];
		num3 = fac[M];
		
		long res = (num1 * power((num2*num3)%MOD,MOD-2)%MOD)%MOD;
		System.out.println(res);

	}

	private static void fac(int n) {
	    fac=new long[n+1];
	    fac[0]=1;
	    fac[1]=1;
	    
	    for (int i = 2; i < n+1; i++) {
	        fac[i]=(fac[i-1]*i)%MOD;
	    }
	}


	static long power(long a, int b) {
		if (b == 1)
			return a;

		long half = power(a, b / 2);

		if (b % 2 == 0)
			return half * half % MOD;
		else
			return (half * half % MOD) * a % MOD;
	}


}
