package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B3_10824_네_수 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken() + st.nextToken();
		String s2 = st.nextToken() + st.nextToken();
		
		System.out.println(Long.parseLong(s1)+ Long.parseLong(s2));
		
		
	}
}
