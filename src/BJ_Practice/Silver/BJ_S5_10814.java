package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_10814 {
	static int N;
	static StringTokenizer st;

	static class Members implements Comparable<Members> {
		int no;
		int age;
		String name;

		public Members(int no, int age, String name) {
			super();
			this.no = no;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Members o) {
			if (this.age == o.age)
				return Integer.compare(this.no, o.no);
			else
				return Integer.compare(this.age, o.age);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		List<Members> list = new ArrayList<>();
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Members(i,age,name));
		}
		
		Collections.sort(list);
		for(Members m : list)
			sb.append(m.age).append(" ").append(m.name).append("\n");
		System.out.println(sb);
	}
}
