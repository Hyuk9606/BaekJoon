package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_10986_나머지_합 {
	static int N,M;
	static long answer= 0L;
	static int data[];
	static int cnt[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		data = new int[N+1];
		cnt = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N ; i++) {
			data[i] = (Integer.parseInt(st.nextToken())+data[i-1]) % M;
			if(data[i] == 0) answer++;
			answer += cnt[data[i]]++;
		}
		
		System.out.println(answer);
	}
}
