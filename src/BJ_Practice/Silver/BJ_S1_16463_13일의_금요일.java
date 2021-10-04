package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_16463_13일의_금요일 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		int startDays = 2;
		int day = 0;

		int year = 2019;
		int answer = 0;
		while (year != N+1) {
			for (int month = 1; month < 13; month++) {
				switch (month) {
				case 4:
				case 6:
				case 9:
				case 11:
					day = 30;
					break;
				case 2:
					if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
						day = 29;
					} else
						day = 28;
					break;
				default:
					day = 31;
				}
				if((startDays + 12) % 7 == 5)
					answer++;
				startDays = (startDays + day) % 7;

			}
			year++;
		}
		System.out.println(answer);

	}
}
