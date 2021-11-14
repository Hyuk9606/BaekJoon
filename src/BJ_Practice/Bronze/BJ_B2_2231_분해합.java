package BJ_Practice.Bronze;

import java.io.*;

public class BJ_B2_2231_분해합 {
	static int N;
	static int answer=9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N ; i++) {
			int sum = i;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length() ; j++) {
				sum += str.charAt(j)-'0';
			}
			if(sum == N) {
				System.out.println(i);
				return;
			}
		}
		
	}
}
