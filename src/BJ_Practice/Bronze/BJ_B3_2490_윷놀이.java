package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B3_2490_윷놀이 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        char[] arr = {'E','A','B','C','D'};
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if(st.nextToken().equals("0")) cnt++;
            }
            System.out.println(arr[cnt]);
            
        }
    }
}
