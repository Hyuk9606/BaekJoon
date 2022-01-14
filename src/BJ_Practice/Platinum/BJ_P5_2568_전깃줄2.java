package BJ_Practice.Platinum;

import java.io.*;
import java.util.*;

public class BJ_P5_2568_전깃줄2 {

	static int N;
	static int[] LIS;
	static StringTokenizer st;
	
	static class elecLine implements Comparable<elecLine>{
		int start,end;

		public elecLine(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(elecLine o) {
			if(this.start < o.start) return -1;
			else if(this.start > o.start ) return 1;
			else return 0;
		}

		@Override
		public String toString() {
			return "elecLine [start=" + start + ", end=" + end + "]\n";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		elecLine[] data = new elecLine[N];
		int[] answer = new int[N];
		LIS = new int[N+1];
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			data[i] = new elecLine(start,end);
		}
		Arrays.sort(data);
		int size = 0;
		for (int i = 0; i < N ; i++) {
			int temp = binarySearch(0, size, data[i].end);
			if(LIS[temp+1] != data[i].end) {
				LIS[temp] = data[i].end;
				answer[i] = temp;
			}
			
			if(temp == size) {
				size++;
			}
		}
	
		
		Stack<Integer> stack = new Stack<>();
		for(int i = N-1; i>=0; i--) {
			if(answer[i] == size - 1) {
				stack.push(data[i].end);
				size--;
				if(size == -1)
					break;
			}
		}
		System.out.println(N-stack.size());
		int index = 0;
//		System.out.println(Arrays.toString(data));
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			while(data[index].end != temp) {
				sb.append(data[index].start).append("\n");
				index++;
			}
			index++;
		}
		while(index < N) {
			sb.append(data[index].start).append("\n");
			index++;
		}
		System.out.println(sb.toString());
		
	}
	
	static int binarySearch(int left, int right, int key) {
		int mid = 0;
		while(left < right) {
			mid = (left+right)/2;
			
			if(LIS[mid] < key) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return right;
	}
}
