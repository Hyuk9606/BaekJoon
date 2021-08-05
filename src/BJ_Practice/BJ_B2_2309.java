package BJ_Practice;

import java.io.*;

public class BJ_B2_2309 {


	static int[] Height;
	static int[] pick;
	
	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum=0;
			for(int i=0; i<7; i++) {
				sum+= pick[i];
			}
			if(sum == 100)
				for(int i=0; i<7; i++) {
					System.out.println(pick[i]);
				}
			
		}
		for (int i = start; i < 9; i++) {
			pick[cnt] = Height[i];
			combination(cnt+1,i+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Height = new int[9];
		pick = new int[7];
		for(int i=0; i<9; i++) {
			Height[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0);		
		
	}
}
