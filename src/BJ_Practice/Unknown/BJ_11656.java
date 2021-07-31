package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_11656 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str1 = br.readLine();
			String[] str2 = new String[str1.length()];
			for (int i = 0; i < str1.length(); i++) {
				str2[i] = str1.substring(i, str1.length());
			}

			for (int i = 1; i < str2.length - 1; i++)
				for (int j = i; j < str2.length; j++) {
					if (str2[j - 1].charAt(0) > str2[j].charAt(0)) {
						String tmp = str2[j - 1];
						str2[j - 1] = str2[j];
						str2[j] = tmp;
					}
				}
			Arrays.sort(str2);
			for (int i = 0; i < str2.length; i++) {
				System.out.println(str2[i]);
			}
		} catch (Exception e) {
		}
	}
}
