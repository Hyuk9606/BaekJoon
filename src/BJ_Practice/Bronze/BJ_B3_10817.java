package BJ_Practice.Bronze;

import java.util.*;

public class BJ_B3_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] input = new int[3];
		input[0] = sc.nextInt();
		input[1] = sc.nextInt();
		input[2] = sc.nextInt();
		Arrays.sort(input);
		
		System.out.println(input[1]);
		
	}
}
