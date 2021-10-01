package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_SW_4013_특이한자석 {
	static int T, K;
	static StringTokenizer st;
	static Gear[] gears;

	static class Gear {
		int magnetic;
		int index;

		public Gear(int magnetic) {
			super();
			this.magnetic = magnetic;
			this.index = 5;
		}

		@Override
		public String toString() {
			return Integer.toBinaryString(magnetic) + " ";
		}

		public void rotateRight() {
			this.index = (index + 1) % 8;
		}

		public void rotateLeft() {
			this.index = (index + 7) % 8;
		}

		public boolean getMagneticRight() {
			return (magnetic & (1 << index)) != 0;
		}

		public boolean getMagneticLeft() {
			return (magnetic & (1 << ((index + 4) % 8))) != 0;
		}
		
		public boolean getZeroIndex() {
			return (magnetic & 1<<((index+2)%8))!=0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			gears = new Gear[4];
			K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				String str = br.readLine().replaceAll(" ", "");
				gears[i] = new Gear(Integer.parseInt(str, 2));
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());

				boolean check[] = new boolean[4];
				for (int j = num; j < 3; j++) {
					if (gears[j].getMagneticRight() != gears[j + 1].getMagneticLeft()) {
//						check[j] = true;
						check[j + 1] = true;
					} else {
						check[j + 1] = false;
						break;
					}

				}
//				System.out.println(gears[1].getMagneticLeft());
//				System.out.println(Arrays.toString(check));
//				
//				System.out.println((gears[0].magnetic & (1<<5)) + " " + (gears[0].magnetic & (1<<1)));
//				System.out.println((gears[1].magnetic & (1<<5)) + " " + (gears[1].magnetic & (1<<1)));
//				System.out.println((gears[2].magnetic & (1<<5)) + " " + (gears[2].magnetic & (1<<1)));
//				System.out.println((gears[3].magnetic & (1<<5)) + " " + (gears[3].magnetic & (1<<1)));
//				
				
				for (int j = num; j > 0; j--) {
					
					if (gears[j].getMagneticLeft() != gears[j - 1].getMagneticRight()) {
//						check[j] = true;
						check[j - 1] = true;
					} else {
						check[j - 1] = false;
						break;
					}
				}
				check[num] = true;
//				System.out.println(Arrays.toString(check));

				for (int j = 0; j < 4; j++) {
					if (check[j]) {
						if (num % 2 == j % 2) {
							rotate(gears[j],direction);
						}else
							rotate(gears[j],direction*-1);
					}
				}
			}
			int answer = 0;
			for (int i = 0; i < 4 ; i++) {
				if(gears[i].getZeroIndex()) {
					answer +=(int)Math.pow(2, i);
					
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static void rotate(Gear g, int dir) {
		if(dir == 1) {
			g.rotateRight();
		}else
			g.rotateLeft();
	}
}

