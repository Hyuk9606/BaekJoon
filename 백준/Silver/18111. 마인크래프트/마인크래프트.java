import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    static int[][] land;
    static int height = 0;
    static int time = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        land = new int[N][M];
        
        int min = 257;
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, land[i][j]);
                max = Math.max(max, land[i][j]);
            }
        }
        

        for (int h = min; h <= max; h++) {
            int remove = 0;
            int fill = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (land[i][j] > h)
                        remove+= land[i][j] - h;
                    else if (land[i][j] < h)
                        fill+= h - land[i][j];
                }
            }
            if (B + remove - fill < 0) continue;
            int spend = remove * 2 + fill;
            if (spend < time) {
                time = spend;
                height = h;
            }
            else if(spend == time){
                height = h;
            }
        }
        System.out.println(time + " " + height);
        
    }
}