package Clear;

import java.io.*;
import java.util.*;

public class BJ_10250 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int floor = (n%h)*100;

				int room = n/h;
				if(floor == 0) System.out.println(h*100+room);
				else System.out.println(floor + room+1);
			}
		}catch(Exception e) {}
	}
}
