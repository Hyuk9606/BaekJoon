package BJ_Practice.Silver;

import java.util.*;

public class BJ_S2_11729 {
	
	private static int cnt=0;
	private static int a;
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	private static void hanoi(int n, int start, int temp, int dest) {
		if(n==0) return ;
		
		cnt++;
		// 자신 위쪽의 n-1개 원판 임시기둥으로 옮기기
		hanoi(n-1,start,dest,temp);

		// 자신을 목적지로 옮기기
		sb.append(start+" " + dest).append("\n");
		// 임시기둥의 n-1개 목적지로 옮기기
		hanoi(n-1,temp,start,dest);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		hanoi(a,1,2,3);
		sb2.append(cnt+"\n");
		System.out.print(sb2);
		System.out.println(sb);

	}
}
