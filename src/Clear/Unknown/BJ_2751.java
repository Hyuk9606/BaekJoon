package Clear.Unknown;

import java.io.*;
import java.util.*;

public class BJ_2751 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int N = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[2000001]; 

			for (int i = 0; i < N; i++)
				check[Integer.parseInt(br.readLine())+1000000] = true;
			
			for (int i = 0; i < 2000001; i++)
				if(check[i])
					bw.write((i-1000000)+"\n");
			bw.flush();
			
			
		} catch (

		Exception e) {
		}
	}
}
