package Clear;

import java.io.*;
import java.util.*;

public class BJ_4948 {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int num = 123456;

			int[] check = new int[num * 2 + 1];
			Arrays.fill(check, 0);

			int current = 2;
			while (current <= num * 2) {
				if (check[current] == 0) {
					for (int i = 2; i <= num * 2; i++) {
						if (i * current > num * 2)
							break;
						check[i * current] = 1;
					}
					check[current] = 0;

				}
				current++;
			}
			check[1] = 1;
			
			while (true) {
				int N = Integer.parseInt(br.readLine());
				if(N == 0) break;
				int sum = 0;
				for (int i = N+1; i <= 2 * N; i++)
					if (check[i] == 0)
						sum += 1;
				System.out.println(sum);
			}
		} catch (Exception e) {
		}
	}
}
