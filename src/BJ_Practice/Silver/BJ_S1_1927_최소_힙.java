package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S1_1927_최소_힙 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) pq.add(x);
			else
				if(!pq.isEmpty())
					System.out.println(pq.poll());
				else
					System.out.println(0);
		}
	}
}
