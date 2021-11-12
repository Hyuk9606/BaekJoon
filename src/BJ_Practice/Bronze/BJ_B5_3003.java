package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B5_3003 {
	static int[] chess = new int[6];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		chess[0] = 1;
		chess[1] = 1;
		chess[2] = 2;
		chess[3] = 2;
		chess[4] = 2;
		chess[5] = 8;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6 ; i++) {
			int num = Integer.parseInt(st.nextToken());
			chess[i] = chess[i]-num;
		}
		
		for(int number : chess) {
			sb.append(number).append(" ");
		}
		System.out.println(sb.toString());
	}
}
