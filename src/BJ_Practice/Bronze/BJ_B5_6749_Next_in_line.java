package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B5_6749_Next_in_line {
	
	static int N,M,ans;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		ans = M*2 - N;
		System.out.println(ans);
	}
}
