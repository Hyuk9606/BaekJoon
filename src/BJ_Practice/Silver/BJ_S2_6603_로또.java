package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_6603_로또 {
	static int K;
	static int[] numbers;
	static int[] select;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		while (true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K==0) break;
			numbers = new int[K];
			for (int i = 0; i < K ; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			select = new int[6];
			comb(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void comb(int cnt, int start) {
		if(cnt == 6) {
			for (int i = 0; i < 6 ; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < K ; i++) {
			select[cnt] = numbers[i];
			comb(cnt+1,i+1);
			
//			comb(cnt,i+1);
			
		}
	}
}
