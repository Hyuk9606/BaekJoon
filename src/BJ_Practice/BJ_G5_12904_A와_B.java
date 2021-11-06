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
		int SLen = S.length();
		int start = 0;
		int end = T.length() - 1;
		
		boolean isReverse = false;
		while (end - start+1 > SLen) {
			if (!isReverse) {
				if (T.charAt(end) == 'B')
					isReverse = true;
				end--;
			} else {
				if(T.charAt(start)=='B')
					isReverse = false;
				start++;
			}
		}
		
		sb.append(T.substring(start, end+1));
		if(isReverse) {
			sb.reverse();
		}
		
		if(S.equals(sb.toString())){
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}


//static boolean cmp(String str) {
//	if (str.length() == TLen) {
//		if (str.equals(T)) {
//			return true;
//		}
//		return false;
//	}
//
//	if (cmp(str + "A")) {
//		return true;
//	}
//
//	String reverse = "";
//	for (int i = str.length() - 1; i >= 0; i--) {
//		reverse += str.charAt(i);
//	}
//
//	if (cmp(reverse + "B")) {
//		return true;
//	}
//
//	return false;
//}

