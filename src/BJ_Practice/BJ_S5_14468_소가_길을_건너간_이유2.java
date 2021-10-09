package BJ_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S5_14468_소가_길을_건너간_이유2 {
	static String str;
	static int check[][] = new int[26][2];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			int cur = str.charAt(i)-'A';
			if(check[cur][0]==0) check[cur][0]=i+1;
			else check[cur][1] = i+1;
		}
		
		int answer = 0;
		for (int i = 0; i < 26 ; i++) {
			for (int j = 0; j < 26 ; j++) {
				if(check[i][0] < check[j][0] && check[j][0] < check[i][1] && check[i][1] < check[j][1])
					answer++;
			}
		}
		System.out.println(answer);
	}
}
