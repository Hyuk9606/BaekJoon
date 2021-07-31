package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_2869 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long v = Integer.parseInt(st.nextToken());
			
			double value = (double)(v-b)/(a-b);

			if(value%1 != 0) value++;
			System.out.println((int)value);
			
		}catch(Exception e) {}
	}
}
