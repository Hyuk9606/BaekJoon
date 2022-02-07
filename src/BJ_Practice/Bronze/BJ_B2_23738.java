package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B2_23738 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String[] alphabet = new String[26];

        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf((char)('a'+i));
        }
        alphabet['B'-'A'] = "v";
        alphabet['E'-'A'] = "ye";
        alphabet['H'-'A'] = "n";
        alphabet['P'-'A'] = "r";
        alphabet['C'-'A'] = "s";
        alphabet['Y'-'A'] = "u";
        alphabet['X'-'A'] = "h";
        String str = br.readLine();
        for (int i = 0; i < str.length() ; i++) {
            sb.append(alphabet[str.charAt(i)-'A']);
        }
        System.out.println(sb.toString());
        
        
        
        
    }
}
