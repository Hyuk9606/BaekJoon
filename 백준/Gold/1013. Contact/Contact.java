import java.io.*;

public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine().trim();
//			String ans = br.readLine();
			int len = str.length();
			int i = 0;
			boolean flag = false;
			if(str.length() < 2 ) {
//				System.out.println(ans.equals("NO"));
				sb.append("NO").append("\n");
				continue;
			}
			
			while (i < len) {
				if (i+1 < len && str.charAt(i) == '1' && str.charAt(i + 1) == '0') {
					i += 2;
					if(i+1 < len && str.charAt(i) == '0') i++;
					else {
						flag = true;
						break;
					}
					while (i < len && str.charAt(i) == '0') i++;
					if (i < len && str.charAt(i) == '1') i++;
					else {
						flag = true;
						break;
					}
					while(i < len && str.charAt(i) == '1') i++;
				} else if(i+1 < len && str.charAt(i)=='0' && str.charAt(i+1) == '1') {
					i+=2;
				} else if(2<=i && str.charAt(i-2) == '1'){
					i-=1;
				}else break;
			}
//			if(!flag && i == len) {
//				System.out.println(ans.equals("YES"));
//			}else System.out.println(ans.equals("NO"));
			
			if(!flag && i == len) {
				sb.append("YES").append("\n");
			}else sb.append("NO").append("\n");
		}
		System.out.println(sb.toString());
	}
}
