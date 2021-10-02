package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_6588 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> primeList = new ArrayList<>();

		boolean[] dp = new boolean[1000001];
		int step = (int) Math.sqrt(1000000);
//		System.out.println(step);
		for (int i = 2; i <= step; i++) {
			if (!dp[i])
				for (int j = i*2; j <= 1000000; j += i) {
					dp[j] = true;
				}
		}
		for (int i = 1; i <=1000000; i++) {
			if (!dp[i])
				primeList.add(i);
		}
//		System.out.println(primeList);
		step = primeList.size();
		while((N = Integer.parseInt(br.readLine())) != 0) {
			boolean flag = false;
			for (int i = 1; i < step ; i++) {
				int number = N - primeList.get(i);
				
				if(number > 0 && !dp[number]) {
					sb.append(N).append(" = ").append(primeList.get(i)).append(" + ").append(number).append("\n");
					flag = true;
					break;
				}
			}
			if(!flag)
				sb.append("Goldbach's conjecture is wrong.");
			
		}
		System.out.println(sb);

	}
}