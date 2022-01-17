package BJ_Practice.Bronze;

import java.io.*;

public class BJ_B3_2442_별찍기5 {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = "";
            for (int j = N-i-1; j > 0; j--) {
                str+= " ";
            }
            for (int j = i; j < 2*i; j++) {
    
                str += "*";
            }
            for (int j = i; j < 2*i; j++) {
    
                str += "*";
            }
            str += "*";
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
