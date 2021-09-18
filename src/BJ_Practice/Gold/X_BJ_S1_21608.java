package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class X_BJ_S1_21608 {
	static int N;
	static int[][] seat;
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static StringTokenizer st;

	static Student[] stuArr;

	static class Student {
		int num;
		int[] friend = new int[4];

		public Student(int num, int f1, int f2, int f3, int f4) {
			super();
			this.num = num;
			this.friend[0] = f1;
			this.friend[1] = f2;
			this.friend[2] = f3;
			this.friend[3] = f4;
		}

		@Override
		public String toString() {
			return "Student [num=" + num + ", friend=" + Arrays.toString(friend) + "]";
		}

	}

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		stuArr = new Student[N * N];
		seat = new int[N][N];
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			int f3 = Integer.parseInt(st.nextToken());
			int f4 = Integer.parseInt(st.nextToken());
			stuArr[i] = new Student(num, f1, f2, f3, f4);
			Arrays.sort(stuArr[i].friend);
		}

//		for(Student s : stuArr)
//			System.out.println(s);
		seat[N / 2][N / 2] = stuArr[0].num;

	}

	static void checkCandidate(int num) {
		Student temp = stuArr[num];
		RC candidate = new RC(-1, -1);
		int maxFriend = 0;

		int candidateSeat[][] = new int[N][N];
		for (int i = 0; i < 4; i++) { // friend search
			int friend = temp.friend[i];

			outer: for (int r = 0; r < N; r++) { // seat search
				for (int c = 0; c < N; c++) {

					if (seat[r][c] == friend) {
						for (int idx = 0; idx < 4; idx++) {
							int nr = r + deltas[idx][0];
							int nc = c + deltas[idx][1];
							if (isIn(nr, nc) && seat[nr][nc] == 0) {
								candidateSeat[nr][nc]++;
								if (maxFriend < candidateSeat[nr][nc]) {
									maxFriend = candidateSeat[nr][nc];
									candidate.r = r;
									candidate.c = c;
								}
							}
						}
						break outer; // 친구는 seat내에 최대 1명이므로 찾으면 break
					}
				}
			} // seat search end
		} // friend search end
		if (candidate.r != -1)
			seat(candidate, temp.num);
		///////////////////////////////////////////////
	}

	static void seat(RC rc, int num) {
		seat[rc.r][rc.c] = num;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
