package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B2_13458_시험_감독 {
	static int N;
	static int[] A;
	static int B, C;
	static long ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			A[i] -= B;
			ans++;
			if(A[i] <= 0) {
				continue;
			}
			
			ans += A[i]/C;
			if(A[i] % C != 0) ans++;
			
		}
		System.out.println(ans);

	}
}
