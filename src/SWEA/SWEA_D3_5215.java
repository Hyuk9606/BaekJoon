package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_5215 {
	static int T, N, L, K;
	static int max = Integer.MIN_VALUE;
	static boolean[] isSelected;
	static int[] cur = { 0, 0 };

	static List<int[]> ingredient = new ArrayList<>();
	static List<int[]> pick = new ArrayList<>();

	static class XY implements Comparable<XY> {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int compareTo(XY o) {
			if (this.x > o.x)
				return 1;
			else
				return -1;
		}

	}

	private static void Combination(int cnt) {
		if (cnt == K) {
			cur = new int[] { 0, 0 };
			return;
		}

		cur[0] += (ingredient.get(cnt))[0];
		cur[1] += (ingredient.get(cnt))[1];
		System.out.print(cur[0] + " " + cur[1]);
		System.out.println();
		if (cur[1] <= L && max < cur[0])
			max = cur[0];
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
			for (int t = 0; t <= T; t++) {
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

				Combination(0);

				System.out.println(max);
//				for(int[] x : ingredient) {
//					System.out.print(x[0] + " " + x[1]);
//					System.out.println();
//				}
				List<Integer> list = new LinkedList<>();
				XY[] xy = new XY[3];
				Collections.sort(xy, (xy1,xy2) ->  {
					if(   
				});

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
