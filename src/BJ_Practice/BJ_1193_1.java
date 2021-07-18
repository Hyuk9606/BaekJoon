package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_1193_1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			
			int x=1,y=1;
			int sum=1;
			for(int i=0;i<A-1; i++) {
				if(y==1) {
					y = x+y;
					x = 1;
					sum++;
				}
				else {
					x++;
					y--;
				}
			}
			if((sum %= 2) == 1) System.out.println(y+"/"+x);
			else System.out.println(x + "/" + y);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

