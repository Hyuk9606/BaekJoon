package Jungol;

import java.io.*;
import java.util.*;

public class JG_2577_회전초밥 {
	static int N, d, k, c;
	static int[] sushi;
	static int[] count;
	static Map<Integer, Integer> map = new HashMap<>();

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		count = new int[d+1];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int cnt =0;
		int answer = 0;
		for (int i = 0; i < k; i++) {
			if(count[sushi[i]] == 0)
				cnt++;
			count[sushi[i]]++;
		}
		
		if (count[c] == 0) answer = cnt+1;
		else answer = cnt;
		
		for (int i = k; i < N+k ; i++) {
			int j = i%N;
			if(count[sushi[j]] == 0) {
				cnt++;
			}
			count[sushi[j]]++;
			count[sushi[i-k]]--;
			if(count[sushi[i-k]] == 0) {
				cnt--;
			}
			if(count[c] == 0) answer = Math.max(answer, cnt+1);
			else answer = Math.max(answer, cnt);
		}
		
		

		System.out.println(answer);
	}
}
