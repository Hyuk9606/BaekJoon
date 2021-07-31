package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_1712 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int result = 0;
			if((C-B)<1) result = -1;
			else result = (int)Math.ceil(A/(C-B))+1;
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
