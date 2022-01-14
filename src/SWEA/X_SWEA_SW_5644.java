package SWEA;

import java.io.*;
import java.util.*;

public class X_SWEA_SW_5644 {
	static class Man {
		int r;
		int c;

		public Man(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}

	}

	static class BC {
		int r;
		int c;
		int coverage;
		int power;
		boolean Aused;
		boolean Bused;

		public BC(int r, int c, int coverage, int power) {
			super();
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.power = power;
			this.Aused = false;
			this.Bused = false;
		}

	}

	static int T, N, M;
	static int sum;
	static StringTokenizer st;
	static Man manA;
	static Man manB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<BC> list = new ArrayList<>();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sum = 0;
			manA = new Man(1, 1);
			manB = new Man(10, 10);
			int[] A = new int[N];
			int[] B = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

			}

			Collections.sort(list, (l1, l2) -> Integer.compare(l1.power, l2.power) * -1);

			int cntA = 0, cntB = 0;
			for (int i = 0; i < list.size(); i++) {
				BC temp = isIn(list.get(i));
				list.set(i, temp);
			}
			int a1 = -1, b1 = -1;
			int a2 = -1, b2 = -1;
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k).Aused == true) {
					if (a1 == -1)
						a1 = k;
					else if (a2 == -1)
						a2 = k;
				}
				if (list.get(k).Bused == true) {
					if (b1 == -1)
						b1 = k;
					else if (b2 == -1)
						b2 = k;
				}
			}

			if (a1 != -1)
				a1 = list.get(a1).power;
			else
				a1 = 0;
			if (a2 != -1)
				a2 = list.get(a2).power;
			else
				a2 = 0;
			if (b1 != -1)
				b1 = list.get(b1).power;
			else
				b1 = 0;
			if (b2 != -1)
				b2 = list.get(b2).power;
			else
				b2 = 0;

			if (a1 == b1) {

				if (a2 != 0 && b2 != 0) {
					if (a2 >= b2)
						sum += a1 + a2;
					else
						sum += a1 + b2;
				} else if (a2 != 0 && b2 == 0) {
					sum += a1 + a2;
				} else if (a2 == 0 && b2 != 0) {
					sum += a1 + b2;
				} else
					sum += a1;
			} else {
				if (a1 != 0 && b1 != 0) {
					sum += a1 + b1;
				} else if (a1 != 0 && b1 == 0) {
					sum += a1;
				} else if (a1 == 0 && b1 != 0) {
					sum += b1;
				}
			}

//			if(a1 != -1 && b1 != -1) {
//				if(a1 == b1) {
//					if(a2 != -1)
//						if(list.get(a1).power > (list.get(a1).power + list.get(a2).power)/2)
//							sum += list.get(a1).power;
//						else
//						sum += list.get(a2).power + list.get(b1).power;
//					else sum += list.get(b1).power;
//				}
//				else sum += list.get(a1).power + list.get(b1).power;
//			}
//			else if( a1 != -1 && b1 == -1 )
//				sum += list.get(a1).power;
//			else if(a1 == -1 && b1 != -1)
//				sum += list.get(b1).power;

			for (int i = 0; i < N; i++) {
				manA = move(manA, A[i]);
				manB = move(manB, B[i]);

				for (int j = 0; j < list.size(); j++) {
					BC temp = isIn(list.get(j));
					list.set(j, temp);
				}
				a1 = -1;
				a2 = -1;
				b1 = -1;
				b2 = -1;
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).Aused == true) {
						if (a1 == -1)
							a1 = k;
						else if (a2 == -1)
							a2 = k;
					}
					if (list.get(k).Bused == true) {
						if (list.get(k).Bused == true) {
							if (b1 == -1)
								b1 = k;
							else if (b2 == -1)
								b2 = k;
						}
					}
				}
//				if (a1 != -1 && b != -1) {
//					if (a1 != b)
//						sum += list.get(a1).power + list.get(b).power;
//					else if( a2 != -1 )
//						sum += list.get(a2).power + list.get(b).power;
//					else sum += list.get(a1).power;
//				} else if (a1 == -1 && b != -1) {
//					sum += list.get(b).power;
//				} else if (a1 != -1) {
//					sum += list.get(a1).power;
//				}

//				if(a1 != -1 && b1 != -1) {
//					if(a1 == b1) {
//						if(a2 != -1)
//							sum += list.get(a2).power + list.get(b1).power;
//						else sum += list.get(b1).power;
//					}
//					else sum += list.get(a1).power + list.get(b1).power;
//				}
//				else if( a1 != -1 && b1 == -1 )
//					sum += list.get(a1).power;
//				else if(a1 == -1 && b1 != -1)
//					sum += list.get(b1).power;

				if (a1 != -1)
					a1 = list.get(a1).power;
				else
					a1 = 0;
				if (a2 != -1)
					a2 = list.get(a2).power;
				else
					a2 = 0;
				if (b1 != -1)
					b1 = list.get(b1).power;
				else
					b1 = 0;
				if (b2 != -1)
					b2 = list.get(b2).power;
				else
					b2 = 0;

				if (a1 == b1) {
					if (a2 != 0 && b2 != 0) {
						if (a2 >= b2)
							sum += a1 + a2;
						else
							sum += a1 + b2;
					} else if (a2 != 0 && b2 == 0) {
						sum += a1 + a2;
					} else if (a2 == 0 && b2 != 0) {
						sum += a1 + b2;
					} else
						sum += a1;
				} else {
					if (a1 != 0 && b1 != 0) {
						sum += a1 + b1;
					} else if (a1 != 0 && b1 == 0) {
						sum += a1;
					} else if (a1 == 0 && b1 != 0) {
						sum += b1;
					} 
				}
			}

			System.out.println(sum);

		} // T.C. end
	}

	static Man move(Man A, int num) {
		switch (num) {
		case 0:
			break;
		case 1:
			A.r -= 1;
			break;
		case 2:
			A.c += 1;
			break;
		case 3:
			A.r += 1;
			break;
		case 4:
			A.c -= 1;
			break;
		}

		return A;
	}

	static BC isIn(BC B) {
		int distA = Math.abs(manA.r - B.c) + Math.abs(manA.c - B.r);
		int distB = Math.abs(manB.r - B.c) + Math.abs(manB.c - B.r);

        B.Aused = distA <= B.coverage;
        B.Bused = distB <= B.coverage;

		return B;
	}

}
