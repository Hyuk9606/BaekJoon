package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B3_4153 {
	static int T;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = -1;
		int b = -1;
		int c = -1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int[] num = new int[3];
			num[0] = a;
			num[1] = b;
			num[2] = c;
			Arrays.sort(num);
			if(a+b+c == 0) break;
			if(num[0]*num[0] + num[1]*num[1] == num[2]*num[2]) System.out.println("right");
			else System.out.println("wrong");
		}
	}

}
