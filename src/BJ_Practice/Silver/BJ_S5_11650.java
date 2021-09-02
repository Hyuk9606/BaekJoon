package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_11650 {
	static int N;
	static StringTokenizer st;

	static class XY implements Comparable<XY> {
		int x, y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(XY o) {
			if(this.x == o.x) return Integer.compare(y, o.y);
			return Integer.compare(x, o.x);
		}

	

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		XY[] arr = new XY[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
	}
}
