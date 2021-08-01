package BJ_Practice.Silver;

import java.util.*;
import java.util.Map.*;

public class BJ_S4_11652 {
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			N = sc.nextInt();

			Map<Long, Integer> map = new HashMap<>();
			Long num;
			for (int i = 0; i < N; i++) {
				num = sc.nextLong();
				if (!map.containsKey(num)) {
					map.put(num, 1);
				} else
					map.put(num, map.get(num) + 1);
			}
			long a = 0;
			int max = Integer.MIN_VALUE;
			Set<Entry<Long, Integer>> entries = map.entrySet();
			for (Entry<Long, Integer> m : entries) {
				if (m.getValue() > max) {
					max = m.getValue();
					a = m.getKey();
				} else if (m.getValue() == max) {
					if (a > m.getKey())
						a = m.getKey();
				}
			}
			System.out.println(a);
			System.out.println();
		} catch (Exception e) {
		}
	}
}
