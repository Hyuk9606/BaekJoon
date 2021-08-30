package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_1181 {
static int T;
static StringTokenizer st;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	List<String> input = new LinkedList<>();
	T = Integer.parseInt(br.readLine());
	for (int t = 1; t <= T; t++) {
		input.add(br.readLine());
	}
	Collections.sort(input,(x,y)->{
		if(x.length() == y.length()) {
			return x.compareTo(y);
		}
		else return Integer.compare(x.length(),y.length());
	});
	System.out.println(input.get(0));
	for (int i = 1; i < T ; i++) {
		if(input.get(i-1).equals(input.get(i)))
				continue;
		System.out.println(input.get(i));
		
	}
}
}
