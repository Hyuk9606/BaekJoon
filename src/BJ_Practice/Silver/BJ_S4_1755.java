package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_1755 {
	static int N,M;	// 입력값을 받기위한 변수 선언
	static String[] eng = // 영문명으로 변환시키기 위한 배열
		{"zero","one","two","three","four","five","six","seven","eight","nine"};
	
	static class Convert implements Comparable<Convert>{
		int number;	// 숫자와
		String numberToEng;	//그 숫자의 영문명을 변수로 저장
		
		// 생성자 선언
		public Convert(int number, String numberToEng) {
			super();
			this.number = number;	
			this.numberToEng = numberToEng;	
		}
		
		// sort를 이용하기 위한 compareTo 메소드 오버라이딩
		@Override
		public int compareTo(Convert o) {
			return this.numberToEng.compareTo(o.numberToEng); // String 값을 사전순 정렬
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 입력값 받아올 버퍼 선언
		StringBuilder sb = new StringBuilder();// 출력하기 전 버퍼에 저장시켜 한번에 출력하기 위한 빌더 선언
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값을 white-space 기준으로 분리하기 위한 tokenizer 선언
		List<Convert> list = new ArrayList<>(); // 각 숫자와 영문명을 저장할 리스트 선언
		
		M = Integer.parseInt(st.nextToken());	// M 입력
		N = Integer.parseInt(st.nextToken());	// N 입력
		int size = N - M + 1;					// M~N의 갯수 계산

		
		String str = "";	// 영문명을 임시저장할 변수
		for (int i = M; i <= N; i++) { 		// M~N에 해당하는 모든 숫자에 대하여 탐색
			if(i<10) {						// 숫자가 10 미만일 경우
				str = eng[i];				// 그 값에 해당하는 영문명을 str에 저장
			}else {
				int ten = i/10;				// 10의 자리에 해당하는 영문의 인덱스
				int one = i%10;				// 1의 자리에 해당하는 영문의 인덱스
				str = eng[ten] + " " + eng[one];	// 공백을 사이에 두고 둘을 합침.
			}
			list.add(new Convert(i,str));		// 리스트에 추가.
		}
		
		Collections.sort(list);			// 정렬 수행
		
		// 출력
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i).number).append(" ");	
			if(i%10 == 9) sb.append("\n");
		}
		System.out.println(sb);		
	}
}
