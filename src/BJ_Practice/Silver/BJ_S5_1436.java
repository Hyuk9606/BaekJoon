package BJ_Practice.Silver;

import java.io.*;

public class BJ_S5_1436 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=666; i<Integer.MAX_VALUE; i++) {
			if(String.valueOf(i).contains("666"))
				cnt++;
			if(cnt == N) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
