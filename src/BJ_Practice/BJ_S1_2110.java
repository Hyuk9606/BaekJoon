package BJ_Practice;

import java.util.*;

public class BJ_S1_2110 {
	public static int N;
	public static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		double gap = (double) (arr[arr.length - 1] - arr[0]) / (C - 1);

		double current = arr[0] + gap;
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > current) {
				if(current - arr[i-1]< arr[i]-current) {
					list.add(arr[i-1]);
				}
				else {
					list.add(arr[i]);
				}
				current+=gap;
			}
		}
		list.add(arr[N-1]);
		int min = Integer.MAX_VALUE;
		for(int i=1 ; i< list.size(); i++) {
			if(list.get(i)-list.get(i-1)<min)
				min = list.get(i)-list.get(i-1);
		}
		System.out.println(min);
	}
}
