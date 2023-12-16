package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2866_문자열_잘라내기 {
    static String[] strs;
    static int R, C;
    
    public static void main(String[] args) {
        input();
        solve();
    }
    
    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            String[] temp = new String[R];
            strs = new String[C];
            
            for (int r = 0; r < R; r++) {
                temp[r] = br.readLine();
            }
            
            for (int c = 0; c < C; c++) {
                StringBuilder sb = new StringBuilder();
                for (int r = 0; r < R; r++) {
                    sb.append(temp[r].charAt(c));
                }
                strs[c] = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void solve() {
        int cnt = 0;
        while (++cnt < R) {
            if (!compareStr(cnt)) {
                break;
            }
        }
        System.out.println(cnt - 1);
    }
    
    static boolean compareStr(int cnt) {
        Set<String> set = new HashSet<>();
        
        for (int c = 0; c < C; c++) {
            String temp = strs[c].substring(cnt, R);
            if (!set.contains(temp)) {
                set.add(temp);
            } else {
                return false;
            }
        }
        return true;
    }
}