package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_1764 {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<String> al1 = new ArrayList<>();
			ArrayList<String> al2 = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				al1.add(br.readLine());
			}
			for (int i = 0; i < m; i++) {
				al2.add(br.readLine());
			}

			al1.sort(null);
			al2.sort(null);
			int i = 0, j = 0;
			//////////////////////////

			/* 정렬 되어 있는 상태이므로 찾은위치의 다음 위치부터 다시 수행 */
			do {
				for (int k = i; k < n; k++)

					if (al1.get(k).equals(al2.get(j))) {
						System.out.println(al2.get(j));
						i = k + 1;
					}
				j++;
				if (i >= n)
					break;
			} while (j < m);

			//////////////////////////

		} catch (Exception e) {

		}
	}
}
