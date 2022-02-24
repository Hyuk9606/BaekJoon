package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S5_1427_소트인사이드 {
    static String str;
    static int[] numbers = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            numbers[str.charAt(i)-'0']++;
        }
    
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < numbers[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
        
    }
}
