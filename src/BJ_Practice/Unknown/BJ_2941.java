package BJ_Practice.Unknown;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2941 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			str = str.replace("c=","#");
			str = str.replace("c-","#");
			str = str.replace("dz=","#");
			str = str.replace("lj","#");
			str = str.replace("d-","#");
			str = str.replace("nj","#");
			str = str.replace("s=","#");
			str = str.replace("z=","#");
			System.out.println(str.length());
			br.close();
			

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
