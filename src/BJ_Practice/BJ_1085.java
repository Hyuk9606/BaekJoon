package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_1085 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int min = 1001;
			if(min > w-x) min = w-x;
			if( min > x) min = x;
			if( min > y) min = y;
			if( min> h-y) min = h-y;
			System.out.println(min);
		}catch(Exception e) {}
	}
}
