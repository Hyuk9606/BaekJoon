package BJ_Practice.Bronze;

import java.io.*;
import java.math.*;
import java.util.*;

public class BJ_B5_1271_엄청난부자2 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		sc.close();
		System.out.println(A.divide(B));
		System.out.println(A.remainder(B));

	}

}
