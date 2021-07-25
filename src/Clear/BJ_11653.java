package Clear;

import java.io.*;
import java.util.*;

public class BJ_11653 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int check[] = new int[n+1];
			int n2 = n;
			Arrays.fill(check, 0);
			for(int i=2; i<=n;i++) {
				while(n2%i == 0){
					check[i]++;
					n2 = n2/i;
				}
				if(n2==1) break;
			}
			for(int i=2; i<=n; i++) {
				if(check[i]>0)
					for(int j=0; j<check[i];j++) {
						System.out.println(i);
					}
			}
							
			
		}catch(Exception e) {}
	}
}
