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
		
		PriorityQueue<Time> waitPQ = new PriorityQueue<>((o1,o2)-> {return o1.start - o2.start;});
		PriorityQueue<Time> ingPQ = new PriorityQueue<>((o1,o2)-> {return o1.end - o2.end;});
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			waitPQ.offer(new Time(start,end));
		}
		int max = -1;
		while(!waitPQ.isEmpty()) {
			Time temp = waitPQ.poll();
			
			if(ingPQ.isEmpty()) {
				ingPQ.add(temp);
				max = Math.max(max, 1);
			}else {
				while(!ingPQ.isEmpty() && ingPQ.peek().end <= temp.start){
					ingPQ.poll();
				}
				ingPQ.offer(temp);
				max = Math.max(max, ingPQ.size());
			}
		}
		System.out.println(max);

	}
}
