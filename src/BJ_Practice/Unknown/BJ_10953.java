package BJ_Practice.Unknown;

import java.io.*;

public class BJ_10953 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.valueOf(br.readLine());
			for(int i = 0;i<T; i++){
				String[] str = br.readLine().split(",");
				System.out.println(Integer.valueOf(str[0])+Integer.valueOf(str[1]));
			}
		}catch(Exception e) {}
	}
}