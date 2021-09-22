package BJ_Practice.Fail;

import java.io.*;
import java.util.*;

public class X_BJ_S1_2110 {
	public static int N;
	public static int C;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(arr);
			double gap = (double) (arr[arr.length - 1] - arr[0]) / (C - 1);

			double current = arr[0] + gap;
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			list1.add(arr[0]);
			list2.add(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > current) {
					list1.add(arr[i - 1]);
					list2.add(arr[i]);
					current += gap;
				}
			}
			list1.add(arr[N - 1]);
			list2.add(arr[N - 1]);
			int min1 = Integer.MAX_VALUE;
			int min2 = Integer.MAX_VALUE;
			for (int i = 1; i < list1.size(); i++) {
				if (list1.get(i) - list1.get(i - 1) < min1)
					min1 = list1.get(i) - list1.get(i - 1);
			}
			for (int i = 1; i < list2.size(); i++) {
				if (list2.get(i) - list2.get(i - 1) < min2)
					min2 = list2.get(i) - list2.get(i - 1);
			}
//
//			System.out.println(list1);
//			System.out.println(list2);
			if(min1 > min2) System.out.println(min1);
			else System.out.println(min2);

		} catch (Exception e) {
		}
	}
}