package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_1208 {

	private static int T;
	private static int restrict;
	private static int[] box = new int[100];

	private static int dump(int iter) {
		int gap = 0;
		int max = 0;
		int min = 99;
		for (int i = 0; i <= iter; i++) {
			

			for (int j = 0; j < 100; j++) {
				if (box[j] > box[max]) {
					max = j;
				}
				if (box[min] > box[j]) {
					min = j;
				}
			}
			if (i < iter) {
				box[max]--;
				box[min]++;
			} else
				gap = box[max] - box[min];
		}
		return gap;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("SWEA1208.txt"));
		Scanner sc = new Scanner(System.in);
		T = 10;
		for (int t = 1; t <= T; t++) {
			restrict = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			System.out.print("#"+t+" ");
			System.out.println(dump(restrict));
		}
	}

}
