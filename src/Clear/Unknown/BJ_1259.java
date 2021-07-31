package Clear.Unknown;

import java.io.*;

public class BJ_1259 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				String str = br.readLine();
				
				if(str.equals("0")) break;
				
				char[] c1 = str.toCharArray();
				char[] c2 = new char[c1.length];
				
				for(int i=c1.length-1; i>=0; i--) {
					c2[i] = c1[c2.length-(i+1)];
				}
				String str2 = new String(c2);
				
				if(str.equals(str2)) System.out.println("yes");
				else System.out.println("no");
			}
			
		}catch(Exception e) {}
	}
}
