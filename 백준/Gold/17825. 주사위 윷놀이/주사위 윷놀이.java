import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] routes = new int[10];
    static int[][] map = new int[5][28];
    static int[][] position = new int[4][2];
    static int maxScore = 0;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        input();
        init();
        go(0, 0);
        System.out.println(maxScore);
    }
    
    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 10; i++) {
                routes[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    static void init() {
        map[0] = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1, -1, -1, -1, -1, -1, -1};
        map[1] = new int[]{0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        map[2] = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        map[3] = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40, -1, -1, -1, -1, -1};
        map[4] = new int[]{25, 30, 35, 40, -1, -1, -1, -1, -1};
    }
    
    static void go(int step, int score) {
        if (step >= 10) {
            maxScore = Math.max(maxScore, score);
            count++;
            return;
        }
        
        outer : for (int p = 0; p < 4; p++) {
            int[] curPos = position[p].clone();
            if (map[curPos[0]][curPos[1]] == -1) continue outer;
            
            int[] nextPos = new int[]{curPos[0], curPos[1] + routes[step]};
            int number = map[nextPos[0]][nextPos[1]];
            
            if (nextPos[0] == 0 && (number == 10 || number == 20 || number == 30 || number == 40)) {
                nextPos[0] = number / 10;
                if (number == 40) {
                    nextPos[1] -= 17;
                }
            } else if (nextPos[0] == 1 &&number >= 25) {
                nextPos[0] = 4;
                nextPos[1] -= 9;
            } else if (nextPos[0] == 2 &&number >= 25) {
                nextPos[0] = 4;
                nextPos[1] -= 13;
            } else if (nextPos[0] == 3 && (number <= 25 || number >= 30)) {
                nextPos[0] = 4;
                nextPos[1] -= 19;
            }
            for (int i = 0; i < 4; i++) {
                if(position[i][0] == 0 && position[i][1] == 0 || (i == p) || number == -1) continue;
                if(position[i][0] == nextPos[0] && position[i][1] == nextPos[1]) continue outer;
            }
            position[p] = nextPos;
            
            go(step + 1, number != -1 ? score + number : score);
            position[p] = curPos;
        }
    }
}