package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_6581_HTML {
    static int currentLineLength = 0;
    static final String HR_VALUE = "--------------------------------------------------------------------------------";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String str = "";
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                if("<br>".equals(word)){
                    sb.append("\n");
                    currentLineLength = 0;
                }else if("<hr>".equals(word)){
                    if(currentLineLength != 0){
                        sb.append("\n");
                    }
                    sb.append(HR_VALUE);
                    sb.append("\n");
                    currentLineLength = 0;
                } else {
                    int wordLength = word.length();
                    int space = currentLineLength == 0 ? 0 : 1;
                    if(currentLineLength + wordLength + space > 80) {
                        sb.append("\n");
                        currentLineLength = 0;
                        space = 0;
                    }
                    if(space == 1) {
                        sb.append(" ");
                    }
                    sb.append(word);
                    currentLineLength += wordLength + space;
                }
            }
        }
        System.out.println(sb);
    }
}
