package BJ_Practice.Bronze;

import java.io.*;

public class BJ_B2_23627_driip {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int len = str.length();
		
		if(len < 5) {
			System.out.println("not cute");
			return;
		}
		char[] c = {'d','r','i','i','p'};
		for (int i = len-5; i < len; i++) {
			if(str.charAt(i) != c[i-len+5]) {
				System.out.println("not cute");
				return;
			}
		}
		System.out.println("cute");
		return;
		
		
	}
}
