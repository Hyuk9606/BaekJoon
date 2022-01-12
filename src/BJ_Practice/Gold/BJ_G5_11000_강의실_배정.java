package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_11000_강의실_배정 {
	
	static int N;
	static StringTokenizer st;
	static class Time{
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Time> pqA = new PriorityQueue<>((o1,o2)-> {return o1.start - o2.start;});
		PriorityQueue<Time> pqB = new PriorityQueue<>((o1,o2)-> {return o1.end - o2.end;});
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pqA.offer(new Time(start,end));
		}
		int max = -1;
		while(!pqA.isEmpty()) {
			Time temp = pqA.poll();
			
			if(pqB.isEmpty()) {
				pqB.add(temp);
				max = Math.max(max, 1);
			}else {
				while(!pqB.isEmpty() && pqB.peek().end <= temp.start){
					pqB.poll();
				}
				pqB.offer(temp);
				max = Math.max(max, pqB.size());
			}
		}
		System.out.println(max);

	}
}
