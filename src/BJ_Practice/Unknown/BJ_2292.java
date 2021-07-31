package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_2292 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int result=0;
			for(int i=1; i<31000; i++) {
				if(3*((i*i)-i)+1 > A-1) {
					result = i;
					break;
				}
			}
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
