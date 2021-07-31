package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_9020_1 {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int num = 10000;

			int[] check = new int[num + 1];
			ArrayList<Integer> list = new ArrayList<Integer>();
			Arrays.fill(check, 0);

			int current = 2;
			while (current <= num) {
				if (check[current] == 0) {
					for (int i = 2; i <= num; i++) {
						if (i * current > num)
							break;
						check[i * current] = 1;
					}
					check[current] = 0;
					list.add(current);
				}
				current++;
			}
			int T = Integer.parseInt(br.readLine());
			for (int step = 0; step < T; step++) {
				int N = Integer.parseInt(br.readLine());
				int p = 0, q = list.size()-1;
				int min = 10000;
				int i = 0;
				int j = 0;
				while (q+1 > p) {
					if (list.get(p) + list.get(q) == N) {
						if (Math.abs(q - p) < min) {
							min = q - p;
							i = p;
							j = q--;
						}
						
					} else if (list.get(p) + list.get(q) < N)
						p++;
					else if (list.get(p) + list.get(q) > N)
						q--;
				}  
				System.out.println(list.get(i) + " " + list.get(j));
			}

		} catch (Exception e) {
		}
	}
}