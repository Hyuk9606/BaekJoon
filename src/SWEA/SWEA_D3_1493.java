package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_1493 {
	static int T, p, q;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			int sum = 1;
			int y1 = 0, x1 = 0;
			for (int i = 1; i < 150; i++) {
				sum += i;
				if (sum > p) {
					x1 = i;
					break;
				}
			}
			y1 = sum - p;
			x1 -= y1 - 1;

			sum = 1;
			int y2 = 0, x2 = 0;
			for (int i = 1; i < 150; i++) {
				sum += i;
				if (sum > q) {
					x2 = i;
					break;
				}
			}
			y2 = sum - q;
			x2 -= y2 - 1;
			

			p = x1 + x2;
			q = y1 + y2;
			
			sum = 1;
			for(int i=2; i<=p; i++) {
				sum += i;
			}
			
			for(int i=p; i<p+q-1; i++) {
				sum += i;
			}
			System.out.println("#" + t + " " + sum);
			

		}
	}
}
