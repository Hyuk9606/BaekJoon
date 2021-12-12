package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S1_2502_떡_먹는_호랑이 {
	static int N,M;
	static int fibo[][];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		fibo = new int[31][2];
		
		fibo[1][0] = fibo[2][1] = 1;
		fibo[1][1] = fibo[2][0] = 0;
		for (int i = 3; i <= 30; i++) {
			fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
		}
		int A = 0 ,B = 0;
		outer : for (int i = 1; i <= 100000; i++) {
			for (int j = i; j <= 100000; j++) {
				int res = fibo[N][0]*i + fibo[N][1]*j;
				if(res > 100000) break;
				else if(res == M) {
					A = i;
					B = j;
					break outer;
				}
			}
		}
		System.out.println(A);
		System.out.println(B);
	}
}
