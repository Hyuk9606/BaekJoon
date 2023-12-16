package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_Zigzag_Conversion {
    
    public static void main(String[] args) throws IOException {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
    
    public static String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int l = 0; l < len; ) {
            
            for (int i = 0; i < numRows; i++, l++) {
                if(l >= len) break;
                sb[i].append(s.charAt(l));
            }
            
            for (int j = numRows - 2; j >= 1; j--, l++) {
                if(l >= len) break;
                sb[j].append(s.charAt(l));
            }
            
        }
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i].toString());
        }
        return sb[0].toString();
    }
    
}
