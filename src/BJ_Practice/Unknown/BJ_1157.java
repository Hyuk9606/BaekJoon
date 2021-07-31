package BJ_Practice.Unknown;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1157 {

		public static void main(String[] args) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
					
				String[] str = br.readLine().split("");
				int[] arr = new int[26];
				Arrays.fill(arr, 0);
				for(int i=0; i<str.length; i++) {
					int j = str[i].charAt(0);
					if(j < 97) arr[j-65]++;
					else arr[j-97]++;
				}
				
				int max = -1;
				int idx=0;
				for(int i=0; i<arr.length;i++) {
					if(max<arr[i]) {
						max = arr[i];
						idx = i;
					}
				}
				
				int cnt=0;
				for(int i=0; i<arr.length;i++) {
					if(max == arr[i]) cnt++;
				}
				if(cnt > 1) System.out.println("?");
				else System.out.printf("%c",idx+65);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
