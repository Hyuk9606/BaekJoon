package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_3078_좋은친구 {

	static int N, K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer>[] nums = new Queue[21];
		for (int i = 1; i <= 20; i++) {
			nums[i] = new LinkedList<>();
		}

		long answer = 0;
		for (int i = 0; i < N; i++) {
			int len = br.readLine().length();
			
			if(nums[len].isEmpty()) {
				nums[len].offer(i);
				continue;
			}
			while(i - nums[len].peek() > K) {
				nums[len].poll();
				if(nums[len].isEmpty()) break;
			}
			
			answer += nums[len].size();
			nums[len].offer(i);
		}
		System.out.println(answer);

	}
}
