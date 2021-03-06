package BJ_Practice.Silver;

import java.util.*;

public class BJ_S3_15649 {

	static int N;
	static int M;
	static int[] numbers;
	
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers= new int[N];
		
		isSelected = new boolean[N + 1];
		permu(0,1);
	}

	public static void permu(int cnt,int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			if (isSelected[i] == true)
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permu(cnt + 1,i+1);
			isSelected[i] = false;
		}
	}
}
