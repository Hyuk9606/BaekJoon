package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S4_1620_나는야_포켓몬_마스터_이다솜 {
    static int N, M;
    static Map<Integer, String> mapOfNumber = new HashMap<>();
    static Map<String,Integer> mapOfName = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            mapOfNumber.put(i, str);
            mapOfName.put(str,i);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.charAt(0) <= '9') {
                sb.append(mapOfNumber.get(Integer.parseInt(str)));
            } else {
                sb.append(mapOfName.get(str));
            }
            sb.append("\n");
        }
    
        System.out.println(sb.toString());
    }
}
