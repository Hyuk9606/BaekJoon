package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G4_16472_고냥이 {
    static int N, Ans = 0;
    static int[] alphabet = new int[26];
    static String str = null;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        
        int start = 0, end = 0, count = 1;
        
        alphabet[str.charAt(0) - 'a']++; // 첫의 인덱스를 alphabet에 반영
        
        while (end < str.length() - 1) {
            end++;
            if (alphabet[str.charAt(end) - 'a']++ == 0) count++;
            
            // count가 N보다 크면 줄어들 때 까지 start를 앞으로 당김.
            while (count > N && start < end) {
                if (--alphabet[str.charAt(start++) - 'a'] == 0) count--;
            }
            
            Ans = Math.max(Ans, end - start + 1);
            
        }
        System.out.println(Ans);
    }
}