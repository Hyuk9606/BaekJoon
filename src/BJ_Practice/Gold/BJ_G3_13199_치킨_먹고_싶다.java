package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_13199_치킨_먹고_싶다 {
	
	static int T;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken()); 
			int money = Integer.parseInt(st.nextToken());
			int coupon = Integer.parseInt(st.nextToken());
			int gift = Integer.parseInt(st.nextToken());
			int remain = 0;
			int a = (money/price)*gift;
			remain = a%coupon;
			int answer = a/coupon*-1;
			if(a >= coupon) {
				answer+=(a - coupon)/(coupon-gift)+1; 
			}
//			a= (a/coupon)*gift + remain;
//			while(a>=coupon) {
//				remain = a%coupon;
//				answer += a/coupon;
//				a = a/coupon*gift + remain;
//			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
