package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S1_1074 {
	static int cnt = 0;
	static int N, x, y;
	static boolean flag = false;

	static void visit(int r, int c, int size) {

		if (flag == true)
			return;

		if (size == 1) {
			for (int i = r; i < r + 2; i++) {
				for (int j = c; j < c + 2; j++) {
					cnt++;
					if (x == i && y == j) {
						flag = true;
						return;
					}
				}
			}
			return;
		}
//		size -= 1;
//		visit(r, c, size);
//		visit(r, c + size, size);
//		visit(r + size, c, size);
//		visit(r + size, c + size, size);

	}

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int x2 = x;
		int y2 = y;
		int r = 0, c = 0;
		while (N > 1) {
			int val = (int) Math.pow(2, --N);
			if (x2 >= val && y2 >= val) {
				r += val;
				c += val;
				cnt += val * val * 3;
				x2-= val;
				y2-= val;
			} else if (y2 >= val) {
				c += val;
				cnt += val * val;
				y2 -= val;
			} else if (x2 >= val) {
				r += val;
				x2 -= val;
				cnt += val * val * 2;
			}
			
			
		}
//		visit(r,c,N);
		
		if( r != x || c != y) {
			visit(r,c,1);
			System.out.println(cnt-1);
		}
		 System.out.println(cnt);
		 
		 
//		System.out.println(r + " " + c);
//		sb.append(cnt - 1);
//		System.out.println(sb);

	}

}
