package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_14469_소가_길을_건너간_이유3 {
	static int N;
	static List<Cow> list = new ArrayList<>();
	static StringTokenizer st;
	
	static class Cow implements Comparable<Cow>{
		int come;
		int time;
		
		public Cow(int come, int time) {
			super();
			this.come = come;
			this.time = time;
		}

		@Override
		public int compareTo(Cow o) {
			return Integer.compare(this.come, o.come);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int come = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list.add(new Cow(come,time));
		}
		
		Collections.sort(list);
		long start = list.get(0).come;
		for (int i = 0; i < N ; i++) {
			Cow temp = list.get(i);
			if(start < temp.come) {
				start = temp.come+temp.time;
			}else {
				start += temp.time;
			}
		}
		
		System.out.println(start);
		
	}
}
