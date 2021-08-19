package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_9663 {
	static int N;
	static char[][] map;
	static int count;
	static int k = 0;

	static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		map = new char[N][N];
		XY[] selected = new XY[N];
		count = 0;
//		comb(0,0,0,selected);
		System.out.println(count);
	}

	

}
