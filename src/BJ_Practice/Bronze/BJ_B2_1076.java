package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B2_1076 {

	static int T;
	static String[] data = new String[] { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet",
			"grey", "white" };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] strs = new String[3];
		for (int i = 0; i < 3; i++) {
			strs[i] = br.readLine();
		}

		String str = "";
		int s = 0;

		for (int i = 0; i < data.length; i++) {
			if (strs[0].equals(data[i]))
				str += String.valueOf(i);
		}
		for (int i = 0; i < data.length; i++) {
			if (strs[1].equals(data[i]))
				str += String.valueOf(i);
		}
		for (int i = 0; i < data.length; i++) {
			if (strs[2].equals(data[i]))
				s = i;
		}
		for (int i = 0; i < s; i++) {
			str += "0";
		}

		System.out.println(Long.parseLong(str));
	}
}
