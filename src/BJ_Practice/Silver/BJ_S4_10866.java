package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_10866 {
	static int T;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		String str = "";
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			switch (str) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollLast()).append("\n");
				break;
			case "front":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.peekFirst()).append("\n");
				break;
			case "back":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.peekLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				int res = deque.isEmpty() == true ? 1:0;
				sb.append(res).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
