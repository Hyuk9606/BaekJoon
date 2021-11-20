package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_9935_문자열_폭발 {

	public static void main(String[] args) throws IOException {
		for (char iii = '1'; iii <= '1' + 9; iii++) {
			for (char kkk = 'a'; kkk < 'a' + 3; kkk++) {
				String s = "";
				s += (char) iii + "" + (char) kkk;
				if(iii == '1'+9) s = "10"+kkk; 
				

				System.setIn(new FileInputStream("./file/eksplozija.in." + s));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringBuilder sb = new StringBuilder();

				String str = br.readLine();
				String boom = br.readLine();
				Stack<Character> stack = new Stack<>();

				int len = str.length();
				int i = 0;
				char c = ' ';
				char comp = boom.charAt(boom.length() - 1);

				while (i < len) {
					c = str.charAt(i++);

					if (c == comp && stack.size() >= boom.length() - 1) {
						char[] chars = new char[boom.length() - 1];
						boolean flag = false;
						for (int j = chars.length - 1; j >= 0; j--) {
							chars[j] = stack.pop();
						}
						for (int j = 0; j < chars.length; j++) {
							if (chars[j] != boom.charAt(j)) {
								flag = true;
								break;
							}
						}
						if (flag) {
							for (int j = 0; j < chars.length; j++) {
								stack.push(chars[j]);
							}
							stack.push(c);
						}
					} else
						stack.push(c);
				}
				Stack<Character> s2 = new Stack<>();
				while (!stack.isEmpty()) {
					s2.push(stack.pop());
				}
				if (s2.isEmpty()) {
					sb.append("FRULA");
//					return;
				}
				while (!s2.isEmpty()) {
					sb.append(s2.pop());
				}
//				System.out.println(sb);
				System.setIn(new FileInputStream("./file/eksplozija.out." + s));
				br = new BufferedReader(new InputStreamReader(System.in));
				String ans = br.readLine();
//				System.out.println(ans);
				System.out.println(sb.toString().equals(ans));
			}
		}
	}
}