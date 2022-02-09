package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S5_1475_방번호 {
    static String str;
    static int[] numbers = new int[10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '9')
                numbers[6]++;
            else numbers[str.charAt(i) - '0']++;
        }
        
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if(i == 6) {
                if(numbers[6] % 2 == 1)
                    numbers[6]++;
                ans = Math.max(numbers[i] / 2, ans);
            }
            else ans = Math.max(numbers[i], ans);
        }
        System.out.println(ans);
    }
}
