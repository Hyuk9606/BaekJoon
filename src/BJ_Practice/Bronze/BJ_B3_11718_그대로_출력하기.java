package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B3_11718_그대로_출력하기 {
	

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}
}
