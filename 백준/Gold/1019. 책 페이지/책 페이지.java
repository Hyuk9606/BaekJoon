import java.io.*;
import java.util.*;

public class Main {
	static long L, U;
	static long count[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		L = 1;
		U = Integer.parseInt(st.nextToken());
		count = new long[10];
		long delta = 1;
		while (L <= U) {
			for (; L % 10 != 0 && L <= U; L++) {
				parse(L, delta);
			}

			for (; U % 10 != 9 && L <= U; U--) {
				parse(U, delta);
			}

			if (L > U)
				break;

			L /= 10;
			U /= 10;
			long rowCnt = U - L + 1;
			for (int i = 0; i < 10; i++) {
				count[i] += delta * rowCnt;
			}
			delta *= 10;
		}
		long answer = 0L;
		for (int i = 0; i < 10 ; i++) {
			answer += i*count[i];
		}
		for (int i = 0; i < 10 ; i++) {
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb);
	}
	

	static void parse(long x, long delta) {
		while (x > 0) {
			count[(int) x % 10] += delta;
			x /= 10;
		}
		
	}
}
