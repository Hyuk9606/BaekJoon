package Jungol;

import java.io.*;
import java.util.*;

public class JG_1828 {

	
	static class SE{
		int start;
		int end;
		public SE(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return " [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<SE> list = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new SE(a,b));
		}
		Collections.sort(list, (l1,l2) -> Integer.compare(l1.end,l2.end));
		
		SE s = list.get(0);
		int a= s.end;
		int cnt = 1;
		for(int i=1; i<list.size(); i++) {
			SE next = list.get(i);
			if(a >= next.start) {
				continue;
			}
			else {
				cnt++;
				a = next.end;
			}
		}
		System.out.println(cnt);
	}
}
