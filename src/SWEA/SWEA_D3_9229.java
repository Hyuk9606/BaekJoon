package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229 {
	static int T,N,M;
	static int[] a;
	static StringTokenizer st;
	static int[] choose;
	static int max;
	

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				a = new int[N];
				choose = new int[2];
				max = -1;
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					a[i] = Integer.parseInt(st.nextToken());
				}
				combination(0,0);
				System.out.println("#" + t + " " + max);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 2) {
			int m = choose[0]+choose[1];
			if(m <= M && max < m)
				max = m;
			return;
		}
		
		for(int i=start; i<N;i++) {	
			choose[cnt] = a[i];
			combination(cnt+1,i+1);	
		}
	}
}
