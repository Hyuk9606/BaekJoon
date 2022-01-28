package BJ_Practice.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B3_3009_네_번째_점 {
    static int [][] data = new int [3][2];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        
        if(data[0][0] == data[1][0]){
            sb.append(data[2][0]).append(" ");
        }else if(data[0][0] == data[2][0]){
            sb.append(data[1][0]).append(" ");
        }else{
            sb.append(data[0][0]).append(" ");
        }
        
        if(data[0][1] == data[1][1]){
            sb.append(data[2][1]).append(" ");
        }else if(data[0][1] == data[2][1]){
            sb.append(data[1][1]).append(" ");
        }else{
            sb.append(data[0][1]).append(" ");
        }
    
        System.out.println(sb.toString());
    }
    
}
