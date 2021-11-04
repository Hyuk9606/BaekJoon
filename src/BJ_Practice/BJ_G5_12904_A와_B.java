package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_12904_A와_B {
	static String S, T;
	static int SLen, TLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		S = br.readLine();
		T = br.readLine();
		TLen = T.length();

		if (cmp(S)) {
			System.out.println(1);
		} else
			System.out.println(0);

	}

	static boolean cmp(String str) {
		if (str.length() == TLen) {
			if (str.equals(T)) {
				return true;
			}
			return false;
		}

		if (cmp(str + "A")) {
			return true;
		}

		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}

		if (cmp(reverse + "B")) {
			return true;
		}

		return false;
	}

}
