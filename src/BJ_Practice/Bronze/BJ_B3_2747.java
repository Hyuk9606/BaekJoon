package BJ_Practice.Bronze;

import java.util.*;

public class BJ_B3_2747 {
	static int N;
	static int[] A;
	static int fibo(int n) {
		if(n ==0) return 0;
		if(n == 1) return 1;

		if(A[n] > 0) return A[n];
		else {
			A[n] = fibo(n-1)+fibo(n-2);
			
			return A[n];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N+1];
		System.out.println(fibo(N));
	}
}
