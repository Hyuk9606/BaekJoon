package Clear;

import java.io.*;
import java.util.*;

public class BJ_1929 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] check = new int[N+1];
			Arrays.fill(check, 0);
			
			int current = 2;
			while(current <= N) {
				if(check[current]==0) {
					for(int i=2;i<=N;i++) {
						if(i*current>N) break;
						check[i*current] = 1;
					}
					check[current] = 0;
					
				}
				current++;
			}
			check[1] = 1;
			for(int i= M; i<=N; i++)
				if(check[i]==0) System.out.println(i);
		}catch(Exception e) {}
	}
}
