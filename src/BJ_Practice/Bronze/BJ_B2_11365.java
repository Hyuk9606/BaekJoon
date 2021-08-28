package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B2_11365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = "";
		while((str = br.readLine()).compareTo("END")!=0) {
			for (int i = str.length()-1; i >= 0 ; i--) {
				sb.append(str.charAt(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
