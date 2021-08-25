package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G4_16236 {
	static int N;
	static int[][] map;
	static StringTokenizer st;
	
	static class shark{
		int r,c;
		int size,eat;
		public shark(int r, int c, int size, int eat) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.eat = eat;
		}
		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", size=" + size + ", eat=" + eat + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		
	}
}
