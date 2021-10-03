package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_2015 {
	static int N,K;
	static long[] data;
	static int count = 0;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//		data = new long[N+1];
//		
//		st = new StringTokenizer(br.readLine());
//		for (int i = 1; i <= N ; i++) {
//			data[i] = Integer.parseInt(st.nextToken()) + data[i-1];
//			if(data[i] == K)
//				count++;
//		}
		for (int i = 0; i < 10 ; i++) {
			System.out.println(i + " : " + (i&-i));
		}
	}
}
