package BJ_Practice.Bronze;

import java.io.*;

public class BJ_B2_2902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length()-1; i++) {
			if(str.charAt(i)=='-') {
				sb.append(str.charAt(++i));
			}
		}
		System.out.println(sb.toString());
	}
}
