package Clear;

import java.io.*;
import java.util.*;

public class BJ_1431 {
	public static void main(String[] args) throws IOException {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int N = Integer.parseInt(br.readLine());
			String[] str = new String[N];
			for(int i=0; i<N; i++) {
				str[i] = br.readLine();
			}
			Arrays.sort(str,(s1,s2)->{
				if(s1.length() != s2.length()) {
					return Integer.compare(s1.length(), s2.length());
				}else if(s1.length() == s2.length()) {
					char[] c1 = s1.toCharArray();
					char[] c2 = s2.toCharArray();
					int sum1 = 0,sum2=0;
					for(int i=0; i<c1.length; i++) {
						if((c1[i]-'0') < 10 ) sum1 += c1[i] - '0';
						if((c2[i]-'0') < 10) sum2 += c2[i]-'0';
					}
					if(sum1!=sum2) return Integer.compare(sum1, sum2);
					else return s1.compareTo(s2);
				}else return s1.compareTo(s2);
			});
			
			for(String s : str)
				System.out.println(s);

		}
		
	}
	
}
