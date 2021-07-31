package BJ_Practice.Unknown;

import java.util.*;

public class BJ_10825 {
	private static Scanner scanner = new Scanner(System.in);

	private static StringBuilder builder = new StringBuilder();

	private static int N;
	private static Student[] students;

	public static void main(String[] args) {
	//	scanner = new Scanner(src);
		N = scanner.nextInt();
		students = new Student[N];
		for (int n = 0; n < N; n++) {
			String name = scanner.next();
			int kor = scanner.nextInt();
			int eng = scanner.nextInt();
			int math = scanner.nextInt();
			Student s = new Student(name, kor, eng, math);
			students[n] = s;
		}

		Arrays.sort(students, (s1, s2) -> {
			if (s1.kor == s2.kor) {
				if (s1.eng == s2.eng) {
					if (s1.math == s2.math) {
						return s1.name.compareTo(s2.name);
					} else {
						return Integer.compare(s1.math, s2.math) * -1;
					}
				} else {
					return Integer.compare(s1.eng, s2.eng);
				}
			} else {
				return Integer.compare(s1.kor, s2.kor) * -1;
			}
		});

		for (Student s : students) {
			// System.out.println(s.name);
			builder.append(s.name).append("\n");
		}
		System.out.println(builder);

	}

	static class Student {
		String name;
		int kor, eng, math;

		public Student(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}

	private static String src = "12\r\n" + "Junkyu 50 60 100\r\n" + "Sangkeun 80 60 50\r\n" + "Sunyoung 80 70 100\r\n"
			+ "Soong 50 60 90\r\n" + "Haebin 50 60 100\r\n" + "Kangsoo 60 80 100\r\n" + "Donghyuk 80 60 100\r\n"
			+ "Sei 70 70 70\r\n" + "Wonseob 70 70 90\r\n" + "Sanghyun 70 70 80\r\n" + "nsj 80 80 80\r\n"
			+ "Taewhan 50 60 90";
}
