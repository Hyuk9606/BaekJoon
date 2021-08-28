package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_11399 {
	static int N;
	static int[] data;

	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		data = new int[N];
		for (int i = 0; i < N ; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		int a = 0;
		int c = N;
		for (int i = 0; i < N ; i++) {
			a += data[i] * c--;
		}
		System.out.println(a);
	}
}
