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

	private static void Combination(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (isSelected[i] == true) {
					cur[0] += (ingredient.get(i))[0];
					cur[1] += (ingredient.get(i))[1];
					if (cur[1] <= L && cur[0] > max) {
						max = cur[0];
					}
				}
			}
			cur =new int[] {0,0};

			return;
		}

		isSelected[cnt] = true;
		Combination(cnt + 1);
		isSelected[cnt] = false;
		Combination(cnt + 1);

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

				isSelected = new boolean[N];
				Combination(0);

				System.out.println("#" + t + " " + max);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
