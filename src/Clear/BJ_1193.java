package Clear;

import java.io.*;
import java.util.*;

public class BJ_1193 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int result = 0;
			int k=0;
			for(int i=1; i<10000; i++) {
				int c = (((i*i)-i)/2)+1;
				if(c > A) {
					if(c==A) result = i;
					else result = i-1;
					k = c-A	;
					break;
				}
				
			}
			int y = result - k + 1;
			
			if(result%2 == 0) System.out.println(y+"/"+k);
			else System.out.println(k+"/"+y);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

