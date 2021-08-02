package BJ_Practice.Silver;

import java.util.*;

public class BJ_S4_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int j = 0; j < T; j++) {
			int n = sc.nextInt();
			long [] arr = new long[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			Arrays.sort(arr);
			
		}
	}
}
