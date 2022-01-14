package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_9663 {
	static int N, cnt;
	static int[] col;

	static void setQueen(int rowNo) {
//		if(!isAvailable(rowNo-1)) return;

		if (rowNo == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			col[rowNo] = i;
			if (isAvailable(rowNo)) {
				setQueen(rowNo + 1);
			}
		}
	}

	static boolean isAvailable(int rowNo) {
		for (int i = 0; i < rowNo; i++) {
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		setQueen(0);
		System.out.println(cnt);
	}

}
