package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B2_1100_하얀칸 {
	
	static int [][] mask = {
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1}
			};
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] map = new char[8][8];
		for (int i = 0; i < 8 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		for (int i = 0; i < 8 ; i++) {
			for (int j = 0; j < 8 ; j++) {
				if(map[i][j] == 'F' && mask[i][j] == 1)
					answer++;
			}
		}
		
		System.out.println(answer);
	}
}
