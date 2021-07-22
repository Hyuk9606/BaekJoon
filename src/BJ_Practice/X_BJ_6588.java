package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_6588 {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {

			int num = 1000000;

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

			int N;
			while (true) {
				N = Integer.parseInt(br.readLine());
				if(N==0) break;
				int p = 0, q = N - 1;
				int i = 0;
				int j = 0;
				while (q + 1 > p) {
					i=list.get(p);
					j = list.get(q);
					if (i + j == N) {
						bw.write(N+" = "+i+" + "+j+ "\n");
						break;

					} else if (i + j < N)
						p++;
					else
						q--;
				}
				if (i == 0 && j == 0)
					bw.write("Goldbach's conjecture is wrong.\n");

					
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (

		Exception e) {
		}
	}
}