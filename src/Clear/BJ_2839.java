package Clear;

import java.io.*;

public class BJ_2839 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int min=1000000;
			int[][] num = new int[1001][1001];
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++ ) {
					num[i][j] = i*5 + 3*j;
					if(num[i][j] ==n)
						if(min > i+j) min = i+j;
				}
			}		
			if(min == 1000000) System.out.println("-1");
			else System.out.println(min);
		}catch(Exception e) {}
	}
}
