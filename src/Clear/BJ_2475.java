package Clear;

import java.io.*;

public class BJ_2475 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			char[] c = br.readLine().replace(" ", "").toCharArray();
			int sum = 0;
			for(int i=0; i<c.length;i++) {
				int n = Character.getNumericValue(c[i]);
				sum += n*n;
			}
			System.out.println(sum%10);

		}catch(Exception e) {}
	}
}
