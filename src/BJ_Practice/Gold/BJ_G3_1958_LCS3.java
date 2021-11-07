package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_1958_LCS3 {
	static int ans = 0;
	static int lcs[][][];
	static char[][] str = new char[3][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3 ; i++) {
			String s = br.readLine();
			str[i] = new char[s.length()+1];
			for (int j = 0; j < s.length() ; j++) {
				str[i][j+1] = s.charAt(j);
			}
		}
		int len1 = str[0].length, len2 = str[1].length, len3 = str[2].length;
		lcs = new int[len1+1][len2+1][len3+1];
		for (int i = 1; i < len1 ; i++) {
			for (int j = 1; j < len2 ; j++) {
				for (int k = 1; k < len3 ; k++) {
					if(str[0][i] == str[1][j] && str[1][j] == str[2][k]) {
						lcs[i][j][k] = lcs[i-1][j-1][k-1] +1;
						ans = Math.max(ans, lcs[i][j][k]);
					}
					else {
						lcs[i][j][k] = Math.max(lcs[i-1][j][k], Math.max(lcs[i][j-1][k], lcs[i][j][k-1]));
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
