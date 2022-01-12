package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_12919_A와_B2 {
	static String S, T;
	static int Slen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		S = br.readLine();
		T = br.readLine();
		Slen = S.length();


		if (solve(T)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static boolean solve(String str) {
		if(str.length() == Slen) {
			if(str.equals(S)) return true;
			return false;
		}
		
		if(str.charAt(str.length()-1) == 'A') {
			if(solve(str.substring(0, str.length()-1))) {
				return true;
			}
		}
		
		if(str.charAt(0) == 'B') {
			StringBuilder reverse = new StringBuilder();
			reverse.append(str.substring(1,str.length()));
			if(solve(reverse.reverse().toString())) {
				return true;
			}
		}
		return false;
	}
}
