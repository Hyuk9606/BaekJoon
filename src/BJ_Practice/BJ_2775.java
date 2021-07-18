package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_2775 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			int[][] num = new int[15][15];
			for(int i=0; i<15; i++) {
				num[i][0] = 1;
				num[0][i] = i+1;
			}

			for(int i=0; i<T; i++) {
				int k = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());
				for(int j=1; j<15; j++) {
					for(int x=1; x<15; x++ ) {
						num[j][x] = num[j-1][x] + num[j][x-1];
					}
				}
				System.out.println(num[k][n-1]);
			}
			
		}catch(Exception e) {}
	}
}
