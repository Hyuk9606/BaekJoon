package BJ_Practice.Unknown;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5622 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			String[] str = br.readLine().split("");
			char[] c = new char[str.length];
			int num=0;
			for(int i=0; i<str.length; i++) {
				c[i] = str[i].charAt(0);
				if(c[i] <68) num += 3;
				else if(c[i] < 71) num +=4;
				else if(c[i] < 74) num +=5;
				else if(c[i] < 77) num +=6;
				else if(c[i] < 80) num +=7;
				else if(c[i] < 84) num +=8;
				else if(c[i] < 87) num +=9;
				else if(c[i] < 91) num +=10;

				
			}
			System.out.println(num);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
