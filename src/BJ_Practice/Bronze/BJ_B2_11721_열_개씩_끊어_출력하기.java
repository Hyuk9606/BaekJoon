package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B2_11721_열_개씩_끊어_출력하기 {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int len = str.length();
		for (int i = 1; i <= len ; i++) {
			sb.append(str.charAt(i-1));
			if((i)%10 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
