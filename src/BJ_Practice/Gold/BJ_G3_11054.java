package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_11054 {
	static int N;
	static int[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(data));

		int[] LIS1 = new int[N];
		int[] LIS2 = new int[N];
		Arrays.fill(LIS1, 1);
		Arrays.fill(LIS2, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (data[j] < data[i])
					LIS1[i] = Math.max(LIS1[j] + 1, LIS1[i]);
			}
		}
		for (int i = N-1; i >=0 ; i--) {
			for (int j = N - 1; j > i; j--) {
				if(data[i] > data[j]) {
					LIS2[i] = Math.max(LIS2[j]+1, LIS2[i]);
				}
			}			
		}
//		System.out.println(Arrays.toString(LIS1));
//		System.out.println(Arrays.toString(LIS2));
//		
		int answer = 0;
		for (int i = 0; i < N ; i++) {
			answer = Math.max(LIS1[i] + LIS2[i], answer);
		}
		System.out.println(answer-1);
	}
}
