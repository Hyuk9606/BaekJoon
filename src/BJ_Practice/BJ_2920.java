package BJ_Practice;

import java.io.*;

public class BJ_2920 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			str = str.replace(" ","");
			int a = Integer.parseInt(str);
			if(a==12345678) System.out.println("ascending");
			else if(a==87654321) System.out.println("descending");
			else System.out.println("mixed");
		}catch(Exception e) {}
	}
}
