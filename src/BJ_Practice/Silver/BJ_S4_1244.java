package BJ_Practice.Silver;

import java.util.*;

public class BJ_S4_1244 {
	private static int N;
	private static int N2;
	private static int[] arr;

	private static void boy(int n) {
		for (int i = 1; i <= N; i++) {
			if (isIn(i * n))
				arr[i * n] = swipe(arr[i * n]);
			else
				break;
		}
	}

	private static boolean isIn(int n) {
		return n > 0 && n <= N;
	}

	private static void girl(int n) {
		int index = 0;
		for (int i = 1; i < N; i++) {
			int l = n - i;
			int r = n + i;
			if (!isIn(l) || !isIn(r)) {
				index = r - n;
				break;
			}
			if (arr[l] == arr[r])
				continue;
			else {
				index = r - n;
				break;
			}
		}
		arr[n] = swipe(arr[n]);
		for (int i = 1; i < index; i++) {
			arr[n - i] = swipe(arr[n - i]);
			arr[n + i] = swipe(arr[n + i]);
		}
	}

	public static int swipe(int n) {
		if (n == 0)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i + 1] = sc.nextInt();
		}

		N2 = sc.nextInt();
		for(int i=0; i<N2; i++) {
			int a = sc.nextInt();
			if(a == 1) boy(sc.nextInt());
			else girl(sc.nextInt());
			
		}
		int cnt=0;
		for(int i=1; i<=N;i++) {
			System.out.print(arr[i] + " ");
			cnt++;
			if(cnt%20 == 0) System.out.println();
		}
	}
}
