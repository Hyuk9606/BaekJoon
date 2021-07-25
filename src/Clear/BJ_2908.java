package Clear;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2908 {
	
	public static int reverse(String str){
		int num=0;
		String[] s = str.split("");
		
		String tmp;
		tmp = s[0];
		s[0] = s[2];
		s[2] = tmp;
		num = (Character.getNumericValue(s[0].charAt(0))*100)
				+(Character.getNumericValue(s[1].charAt(0))*10)
				+(Character.getNumericValue(s[2].charAt(0)));
		
		return num;
	}
	
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] st = br.readLine().split(" ");
			
			int a=reverse(st[0]);
			int b=reverse(st[1]);
			if(a>b) System.out.println(a);
			else System.out.println(b);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
