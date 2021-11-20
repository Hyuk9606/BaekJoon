package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_1011_Fly_me_to_the_Alpha_Centauri {
	static int N;
	static int gap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			gap = end - start;
			
			int root = (int)Math.sqrt(gap);
			int add = gap - (int)Math.pow(root, 2);
			int cnt = 0;
			while(add > 0) {
				add -= root;
				cnt++;
			}
			sb.append(root*2-1 + cnt).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
