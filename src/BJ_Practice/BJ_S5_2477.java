package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S5_2477 {
	static int K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		K = Integer.parseInt(br.readLine());
		int[] data = new int[6];
		int[] index = new int[6];
		int max = Integer.MIN_VALUE;
		int x=0;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			index[i] = direction;
			data[i] = value;
			if(value > max) {
				max = value;
				x = i;
			}
		}
		int gap=0;
		if(data[(x+5)%6] > data[(x+1)%6]) {
			gap = -1;
		}else gap = 1;
		
		int ans = K*(data[x]*data[(x+gap+6)%6] - data[(x+gap*-2+6)%6]*data[(x+gap*-3+6)%6]);
		System.out.println(ans);
		
	
	}
}