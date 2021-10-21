package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_11723 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Set<Integer> set = new HashSet<>();
		
		N = Integer.parseInt(br.readLine());
		int result;
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("add")) set.add(Integer.parseInt(st.nextToken()));
			else if(str.equals("check")) {
				result = set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0;
				sb.append(result).append("\n");
			}
			else if(str.equals("remove")) set.remove(Integer.parseInt(st.nextToken()));
			else if(str.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				}else set.add(num);
			}
			else if(str.equals("all")) {
				for (int j = 1; j < 21 ; j++) {
					set.add(j);
				}
			}else {
				set.clear();
			}
			
		}
		System.out.println(sb);
	}
}
