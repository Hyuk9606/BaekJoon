package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_1764 {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<String> al1 = new ArrayList<>();


			for (int i = 0; i < n; i++) {
				al1.add(br.readLine());
			}
			for (int i = 0; i < m; i++) {
				al1.add(br.readLine());
			}
			
			al1.sort(null);
			int count=0;
			for (int i = 1; i < n+m ; i++) {
				if(al1.get(i).compareTo(al1.get(i-1)) == 0){
					count++;
					sb.append(al1.get(i)).append("\n");
				}
			}
			System.out.println(count);
			System.out.println(sb);
			
			//////////////////////////

			/* 정렬 되어 있는 상태이므로 찾은위치의 다음 위치부터 다시 수행 */
			
			
			

			//////////////////////////

		} catch (Exception e) {
			
		}
	}
}