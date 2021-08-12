package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_6808 {
	static int T;
	static int[] numbers1;
	static int[] numbers2;
	static int[] selected;
	static int cnt1, cnt2;
	static StringTokenizer st;

	static void permunitation(int cnt, int flag) {
		if (cnt == 9) {
//			System.out.println(Arrays.toString(selected));
			int score1 = 0;
			int score2 = 0;
			for (int i = 0; i < 9; i++) {
				if (selected[i] > numbers1[i])
					score1 += selected[i] + numbers1[i];
				else if(selected[i] < numbers1[i])
					score2 += numbers1[i] + selected[i];
			}
			if (score1 > score2)
				cnt1++;
			else if (score2 > score1)
				cnt2++;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			selected[cnt] = numbers2[i];
			permunitation(cnt + 1, flag | 1 << i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			selected = new int[9];
			numbers1 = new int[9];
			numbers2 = new int[9];
			cnt1 = 0;
			cnt2 = 0;
			boolean[] check = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
			int j = 0;
			int k= 0;
			for (int i = 1; i < 19; i++) {
				if (check[i] == false)
					numbers1[j++] = i;
				else numbers2[k++] = i;
			}
			permunitation(0,0);
			sb.append("#").append(t).append(" ").append(cnt2).append(" ").append(cnt1).append("\n");
		}
		System.out.println(sb);
	}
}

