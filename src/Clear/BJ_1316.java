package Clear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1316 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());			
			int[] num = new int[26];			
			int sum=0;
			
			outer: for(int i=0; i<n;i++) {
				Arrays.fill(num,0);
				String[] str2 = (br.readLine()+"#").split("");

				
				for(int j=1; j<str2.length;j++) {
					int pre = str2[j-1].charAt(0)-97;
					
					if(str2[j - 1].equals(str2[j])) continue;
					
					num[pre]++;
					
					if(num[pre] > 1) continue outer;
				}
				sum+=1;
			}	
			System.out.println(sum);						
					
					
					
			/*		if(str2[j-1].equals(str2[j])) {
						if(j == str2.length-1)
							num[pre]++;
						continue;
					}
					 
					else {						
						num[pre]++;
						if(j == str2.length-1) {
							num[current]++;
						}
					}
					if(num[current]>1||num[pre]>1) continue outer;*/

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


