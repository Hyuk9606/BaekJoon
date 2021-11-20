package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B1_1032 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		
		for (int i = 0; i < N ; i++) {
			strs[i] = br.readLine();
		}
		if(N==1) { 
			System.out.println(strs[0]);
			System.exit(0);
		}
		int len = strs[0].length();
		out : for (int i = 0; i < len ; i++) {
			char sub = strs[0].charAt(i);
			boolean flag= false;
			for (int j = 1; j < N ; j++) {
				if(strs[j].charAt(i) != sub) {
					flag = true;
					sb.append("?");
					continue out;
				}
			}
			if(!flag) sb.append(sub);
		}
		
		System.out.println(sb.toString());
		
		
	}
}
