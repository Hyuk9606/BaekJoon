package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_1009 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long result = 1;
				for (int j = 0; j < b; j++) {
					result *= a;
					result %= 10;
				}
				if (result == 0)
					System.out.println("10");
				else
					System.out.println(result);
			}

		} catch (Exception e) {
		}
	}
}
