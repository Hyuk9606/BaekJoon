package Clear;

import java.io.*;
import java.math.*;
import java.util.*;

public class BJ_10757 {
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			A = A.add(B);
			System.out.println(A.toString());
			
		}catch(Exception e) {}
	}
}
