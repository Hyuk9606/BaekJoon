package BJ_Practice.Bronze;
import java.io.*;
import java.util.*;

public class BJ_B1_1924_2007년 {

	static int x, y;
	static String[] weeks = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int day = 0;
		for (int i = 1; i < x; i++) {
			if (i == 2) {
				day += 28;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				day += 30;
			} else
				day += 31;
		}
		day += y;
		System.out.println(weeks[day%7]);
	}
}
