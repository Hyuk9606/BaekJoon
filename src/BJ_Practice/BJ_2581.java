package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_2581 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int M = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			
			int[] check = new int[N+1];
			Arrays.fill(check, 0);
			outer: for(int i=M; i<=N; i++) {
				int cnt = 0;
				for(int j=1; j<=i; j++) {
					if((i%j) == 0) cnt++;
					if(cnt > 2) continue outer;
				}
				check[i] = 1;
			}
			check[0] = 0;
			check[1] = 0;
			int min=0;
			for(int i=0; i<=N;i++) {
				if(check[i]==1) {
					min=i;
					break;
				}
			}
			
			int sum = 0;
			for(int i=0; i<=N;i++) {
				if(check[i]==1) sum += i;
			}
			
			
			if( min == 0) System.out.println("-1");
			else {
				System.out.println(sum);
				System.out.println(min);
			}
		}catch(Exception e) {}
	}
}
