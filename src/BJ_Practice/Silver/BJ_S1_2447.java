package BJ_Practice.Silver;

import java.util.*;

public class BJ_S1_2447 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	static void star(int r, int c, int num) {

		 if (((r / num) % 3 == 1 && (c / num) % 3 == 1)) {
			sb.append(" ");
		 }
		 else {
			 if(num/3 == 0)
				 sb.append("*");
			 else{
				 star(r,c,num/3);
			 }
		 }
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				star(i, j, N);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
