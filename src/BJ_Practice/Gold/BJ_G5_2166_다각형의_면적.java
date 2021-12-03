package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2166_다각형의_면적 {

	static int N;
	static StringTokenizer st;

	static class XY {
		int x, y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		XY[] arr = new XY[N+1];
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new XY(x,y);
		}
		arr[N] = arr[0];
		
		double sum1 = 0, sum2 = 0;
		for (int i = 0; i < N ; i++) {
			sum1 += (double)arr[i].x * arr[i+1].y;
			sum2 += (double)arr[i].y* arr[i+1].x;
		}
		double ans = Math.abs((sum1-sum2)*0.5);
		System.out.printf("%.1f",ans);

	}
}
