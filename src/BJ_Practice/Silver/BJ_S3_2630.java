package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_2630 {
	static int N;
	static int[][] map;
	static int white, blue;

	static void divide(int r, int c, int size) {
		int sum = 0;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}

		if (sum == size*size) {
			blue++;
		} else if (sum == 0) {
			white++;
		} else {
			size /= 2;
			divide(r, c, size);
			divide(r, c + size, size);
			divide(r + size, c, size);
			divide(r + size, c + size, size);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
}
