package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_14467_소가_길을_건너간_이유1 {
	static int N;
	static int[] data = new int[101];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int answer = 0;
		Arrays.fill(data, -1);
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(data[num] == -1) {
				data[num] = value;
			}else if(data[num] != value) {
				data[num] = value;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
