package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_5432 {

	static int T;
	static int Answer;
	static char[] arr;
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t <= T; t++) {
			Answer = 0;
			stack = new Stack<Character>();

			arr = br.readLine().toCharArray();

			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == '(' && arr[i + 1] == ')') {
					arr[i] = '$';
					arr[i + 1] = '%';
				}
			}

			int i = 0;
			while (i < arr.length) {
				if (arr[i] == '(')
					stack.push(arr[i]);
				else if (arr[i] == ')') {
					stack.pop();
					Answer += 1;
				} else if (arr[i] == '$') {
					Answer += stack.size();
				}
				i++;
			}
			System.out.println("#" + t + " " + Answer);
		}
	}
}
