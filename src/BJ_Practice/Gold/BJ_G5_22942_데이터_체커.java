package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_22942_데이터_체커 {

	static int N;
	static boolean flag = false;
	static StringTokenizer st;

	static class Checker implements Comparable<Checker>{
		int no;
		int dot;

		public Checker(int no, int dot) {
			super();
			this.no = no;
			this.dot = dot;
		}

		@Override
		public int compareTo(Checker o) {
			if(this.dot == o.dot) flag = true;
			return this.dot - o.dot;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Checker> pq = new PriorityQueue<>();
		Stack<Integer> stack = new Stack<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			pq.add(new Checker(i,x-r));
			pq.add(new Checker(i,x+r));
		}
		
		if(flag) {
			System.out.println("NO");
			return;
		}
		
		while(!pq.isEmpty()) {
			if(stack.isEmpty()) {
				stack.push(pq.poll().no);
			}
			else {
				int number = pq.poll().no;
				if(stack.peek() == number) {
					stack.pop();
				}
				else{
					stack.push(number);
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}
