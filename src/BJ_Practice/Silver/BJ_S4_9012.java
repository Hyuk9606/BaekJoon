package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_9012 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		outer: for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int check = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					check++;
				} else
					check--;
				if (check < 0) {
					System.out.println("NO");
					continue outer;
				}
			}
			if(check == 0) System.out.println("YES");
			else System.out.println("NO");
		}

	}
}
