package BJ_Practice;

import java.io.*;
import java.util.StringTokenizer;


public class BJ_1152 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum=0;
			
			while(st.hasMoreTokens()) {
				st.nextToken();
				sum++;
			}
			
			System.out.println(sum);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
