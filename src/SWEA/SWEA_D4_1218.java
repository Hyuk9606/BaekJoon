package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_1218 {
	static int N, Answer;
	static char[] input;

	static boolean isLeft(char c) {
		if (c == '(' || c == '[' || c == '{' || c == '<')
			return true;
		else
			return false;
	}

	static boolean isRight(char c) {
		if (c == ')' || c == ']' || c == '}' || c == '>')
			return true;
		else
			return false;
	}

	static boolean isValid(char c1, char c2) {
		switch (c1) {
		case '(':
			if (c2 == ')')
				return true;
		case '[':
			if (c2 == ']')
				return true;
		case '{':
			if (c2 == '}')
				return true;
		case '<':
			if (c2 == '>')
				return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			Answer = 0;
			input = new char[N];
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				input[i] = str.charAt(i);
			}

			Stack<Character> st1 = new Stack<>();

			int i = 0;
			outer : while (i < N) {
				if (isLeft(input[i])) {
					st1.push(input[i++]);
					if (i == N)
						break;
				}
				if (isRight(input[i])) {
					try {
						if (!isValid(st1.pop(), input[i++])) {
							Answer = 0;
							break outer;
						}
					} catch (EmptyStackException e) {
						Answer = 0;
						break outer;

					}
				}
				Answer = 1;
			}
			sb.append("#").append(t).append(" ").append(Answer).append("\n");
		}
		System.out.println(sb);
	}
}

