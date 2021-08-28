package BJ_Practice.Silver;

import java.io.*;

public class BJ_S5_9655 {
	static int T;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		if(T%2 == 1) System.out.println("SK");
		else System.out.println("CY");

	}
}
