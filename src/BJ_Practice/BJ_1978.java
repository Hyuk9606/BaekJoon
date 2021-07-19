package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_1978 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] num = new int[k];
			int max = 0;
			for(int i=0; i<k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				if(num[i]>max) max = num[i];
			}
			
			int[] check = new int[1001];
			Arrays.fill(check, 0);
			
			outer: for(int i=2; i<=max; i++) {
				int cnt2 = 0;
				for(int j=1; j<=i; j++) {
					if((i%j) == 0) cnt2++;
					if(cnt2 > 2) continue outer;
				}
				check[i] = 1;
			}
			int sum=0;
			for(int i:num) {
				sum += check[i];
			}
			System.out.println(sum);
		}catch(Exception e) {}
		
	}
}
