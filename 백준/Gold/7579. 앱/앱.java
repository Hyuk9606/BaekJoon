import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[] memory;
	static int[] cost;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memory = new int[N+1];
		cost = new int[N+1];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N ; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N ; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}
		
		int[][] dp = new int[N+1][sum+1];
		for (int i = 1; i <= N ; i++) {
			for (int j = 0; j <= sum ; j++) {
				if(j - cost[i] >= 0)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i]]+memory[i]);
				dp[i][j] = Math.max(dp[i][j],  dp[i-1][j]);
			}
		}
		
		for (int i = 0; i <=sum ; i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}
		
	}
}