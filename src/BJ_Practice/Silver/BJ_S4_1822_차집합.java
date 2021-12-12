package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_1822_차집합 {

	static int N, M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Set<Integer> set = new TreeSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num))
				set.remove(num);
		}
		if(set.size() == 0) set.add(0);
		else System.out.println(set.size());
		for (Integer n : set) {
			sb.append(n).append(" ");
		}
		System.out.println(sb.toString());

	}

}
