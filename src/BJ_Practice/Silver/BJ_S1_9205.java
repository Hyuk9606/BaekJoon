package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_9205 {
	static int T, N;
	static StringTokenizer st;
	static XY[] point;

	static class XY {
		int x, y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			int x, y;
			
			point = new XY[N+2];
			
			for (int i = 0; i <= N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken()) + 32768;
				y = Integer.parseInt(st.nextToken()) + 32768;
				point[i] = new XY(x, y);
			}
			int [][] arr = new int[N+2][N+2];
            for(int i=0; i<N+2; i++)
                for(int j=0; j<N+2; j++)
                    arr[i][j]=999999;
            
                 
            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(i==j)
                        continue;
                    
                    XY current = point[i];
                    XY next = point[j];
                    
                    int dist = Math.abs(current.x-next.x)+Math.abs(current.y-next.y);
                    if(dist<=1000)
                        arr[i][j] = 1;
                }
            }
            for(int k=0; k<N+2; k++) {
                for(int i=0; i<N+2; i++) {
                    for(int j=0; j<N+2; j++) {
                        if(arr[i][j] > arr[i][k] + arr[k][j])
                            arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
            if(0<arr[0][N+1] && arr[0][N+1]<999999)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
    
}
		
