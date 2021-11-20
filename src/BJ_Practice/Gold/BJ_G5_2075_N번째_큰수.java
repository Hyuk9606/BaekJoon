package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2075_N번째_큰수 {
	
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N ; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < N-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}
