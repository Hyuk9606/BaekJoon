package BJ_Practice.Platinum;

import java.io.*;
import java.util.*;

public class BJ_P5_10875_뱀 {

	static int L, N;
	static int curx = 0, cury = 0;
	static int dir = 0;
	static long liveTime = 0;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Line current = null;
	static List<Line> list = new ArrayList<>();
	static StringTokenizer st;

	static class Line {
		int x1, y1;
		int x2, y2;
		boolean isWidth;

		public Line(int x1, int y1, int x2, int y2, boolean isWidth) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.isWidth = isWidth;
		}

		@Override
		public String toString() {
			return "\nLine [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", isWidth=" + isWidth + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		boolean flag = false;

		int time = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());

			int nx = curx + deltas[dir][0] * time;
			int ny = cury + deltas[dir][1] * time;

			if (dir == 1 || dir == 3) {
				current = new Line(curx, cury, nx, ny, false);
			} else {
				current = new Line(curx, cury, nx, ny, true);
			}

			if (checkCross(current)) {
				if (isIn(nx) && isIn(ny))
					liveTime += time;
			} else {
				flag = true;
				break;
			}

			if (!isIn(nx)) {
				if (dir == 0) {
					liveTime += L - curx + 1;
				} else if (dir == 2) {
					liveTime += Math.abs(L * -1 - curx) + 1;
				}
				flag = true;
				break;
			}

			if (!isIn(ny)) {
				if (dir == 1) {
					liveTime += L - cury + 1;
				} else if (dir == 3) {
					liveTime += Math.abs(L * -1 - cury) + 1;
				}
				flag = true;
				break;
			}

			if (dir == 0 || dir == 1)
				list.add(current);
			else
				list.add(new Line(nx, ny, curx, cury, current.isWidth));
			curx = nx;
			cury = ny;

			char direct = st.nextToken().charAt(0);
			switch (direct) {
			case 'L':
				dir = (dir + 3) % 4;
				break;
			case 'R':
				dir = (dir + 1) % 4;
				break;
			}
		}
		if (!flag) {
			int nx = curx + deltas[dir][0];
			int ny = cury + deltas[dir][1];

			if (dir == 0) {
				nx = L;
			} else if (dir == 1) {
				ny = L;
			} else if (dir == 2) {
				nx = -L;
			} else {
				ny = -L;
			}

			if (dir == 1 || dir == 3) {
				current = new Line(curx, cury, nx, ny, false);
			} else {
				current = new Line(curx, cury, nx, ny, true);
			}
			if (checkCross(current)) {
				liveTime += Math.abs(nx - curx) + Math.abs(ny - cury) + 1;
			}
		}

		System.out.println(liveTime);

	}

	static boolean checkCross(Line current) {
		int size = list.size()-1;
		int dist = Integer.MAX_VALUE;
		boolean die = false;
		for (int i = size; i >=0; i--) {
			Line temp = list.get(i);
			if (current.isWidth) {
				if (temp.isWidth && current.y1 == temp.y1) {
					if (dir == 2 && current.x1 > temp.x1 &&current.x2 <= temp.x2) {
						dist = Math.min(Math.abs(current.x1 - temp.x2),dist);
						die = true;
					} else if (dir == 0 && current.x1 < temp.x1 &&current.x2 >= temp.x1) {
						dist = Math.min(Math.abs(temp.x1 - current.x1),dist);
						die = true;
					}
				} else if (!temp.isWidth && temp.y1 <= current.y1 && current.y1 <= temp.y2) {
					if (dir == 0 && current.x1 < temp.x1 && temp.x1 <= current.x2) {
						dist= Math.min(Math.abs(temp.x1 - current.x1),dist);
						die = true;
					} else if (dir == 2 && current.x2 <= temp.x1 && temp.x1 < current.x1) {
						dist= Math.min(Math.abs(current.x1 - temp.x1),dist);
						die = true;
					}
				}
			} else {
				if (!temp.isWidth && current.x1 == temp.x1) {
					if (dir == 3 && current.y1 > temp.y1 && current.y2 <= temp.y2) {
						dist= Math.min(Math.abs(current.y1 - temp.y2),dist);
						die = true;
					} else if (dir == 1 && current.y1 < temp.y1 &&current.y2 >= temp.y1) {
						dist= Math.min(Math.abs(temp.y1 - current.y1),dist);
						die = true;
					}
				} else if (temp.isWidth && temp.x1 <= current.x1 && current.x1 <= temp.x2) {
					if (dir == 3 && current.y2 <= temp.y1 && temp.y1 < current.y1) {
						dist= Math.min(Math.abs(current.y1 - temp.y1),dist);
						die = true;
					} else if (dir == 1 && current.y1 < temp.y1 && temp.y1 <= current.y2) {
						dist= Math.min(Math.abs(temp.y1 - current.y1),dist);
						die = true;
					}
				}
			}
		}
		
		if(die) {
			liveTime += dist;
			return false;
		}
		return true;
	}

	static boolean isIn(int pos) {
		return -L <= pos && pos <= L;
	}
}
