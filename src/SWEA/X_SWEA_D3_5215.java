package SWEA;

import java.io.*;
import java.util.*;

public class X_SWEA_D3_5215 {
	static int T, N, L, K;
	static int max = Integer.MIN_VALUE;
	static boolean[] isSelected;
	static int[] cur = { 0, 0 };

	static List<int[]> ingredient = new ArrayList<>();
	static List<int[]> pick = new ArrayList<>();

	private static void powerSet(int cnt, int sat, int cal) {
		if (cal >= L)
			return;
		if (cnt == N) {
			max = Math.max(max, sat);
			System.out.println(sat);
			return;
		}


		isSelected[cnt] = true;
		powerSet(cnt - 1, sat + (ingredient.get(cnt))[0], cal + (ingredient.get(cnt))[1]);
		isSelected[cnt] = false;
		powerSet(cnt - 1, sat, cal);

	};

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());

				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					int[] element = new int[2];
					element[0] = Integer.parseInt(st.nextToken());
					element[1] = Integer.parseInt(st.nextToken());
					ingredient.add(element);
				}
				
				powerSet(N, 0, 0);
				System.out.println("#" + t + " " + max);

			}

		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
