package Clear.Unknown;

import java.io.*;
import java.util.*;

public class BJ_18310 {
	static int N;

	public static int distance(int[] num, int mid) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.abs(num[i] - num[mid]);
		}
		return sum;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
			int mid = N / 2;
			int A;
			if (N % 2 != 0)
				System.out.println(num[mid]);
			else if (N % 2 == 0) {
				A = distance(num, mid);
				if (A <= distance(num, mid - 1))
					System.out.println(num[mid - 1]);
				else
					System.out.println(num[mid]);
			}

		} catch (Exception e) {
		}
	}
}
