package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1715 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int answer = 0;

		if (N == 1) {
			System.out.println(0);
			return;
		}

		while (pq.size() > 2) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			int sum = num1 + num2;
			answer += sum;
			pq.offer(sum);
		}
		if (pq.size() <= 2) {
			while (!pq.isEmpty())
				answer += pq.poll();
		}
		System.out.println(answer);
	}
}
