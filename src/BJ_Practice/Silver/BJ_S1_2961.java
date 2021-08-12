package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_2961 {
	static int N;
	static int[][] data;
	static int min = Integer.MAX_VALUE; 
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N][2];

		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < Math.pow(2, N); i++) {
			String powerSet = Integer.toBinaryString(i);
			String check = "";
			int a = N - powerSet.length();
			for (int j = 0; j < a; j++) {
				check = check.concat("0");
			}
			check = check.concat(powerSet);
			int sour=1;
			int bitters = 0;
			for (int j = 0; j < N; j++) {
				if(check.charAt(j) == '1') {
					sour *= data[j][0];
					bitters += data[j][1];
				}
			}
			int taste = Math.abs(sour - bitters);
			min = min>taste ? taste : min;
		}
		System.out.println(min);
	}
}
