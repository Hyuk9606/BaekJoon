package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_팩맨 {
    static int M, T;
    static Position packMan;
    static List<Monster>[][] map = new LinkedList[4][4];
    static int[][] deltas = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    
    static class Monster {
        int status;
        int dir;
        Position pos;
        int deadCnt = -1;
        
        public Monster(int status, int dir, int r, int c) {
            this.status = status;
            this.dir = dir;
            this.pos = new Position(r, c);
        }
    }
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        packMan = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = new LinkedList<>();
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            Monster monster = new Monster(0, d, r, c);
            map[r][c].add(monster);
        }
        for (int t = 0; t < T; t++) {
            duplicate();
            monsterMove();
            packManMove();
            exorcist();
            hatch();
        }
        System.out.println(countMonster());
    }
    
    static void duplicate() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int size = map[r][c].size();
                for (int i = 0; i < size; i++) {
                    Monster m = map[r][c].get(i);
                    if (m.status == 0) {
                        Monster newMonster = new Monster(1,m.dir,r,c);
                        map[r][c].add(newMonster);
                    }
                }
            }
        }
    }
    
    static void monsterMove() {
        List<Monster> waitingList = new ArrayList<>();
        boolean[][] movable = isMovable();
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (int i = 0; i < map[r][c].size(); i++) {
                    Monster m = map[r][c].get(i);
                    if (m.status != 0) continue;
                    Position pos = m.pos;
                    for (int d = 0; d < 8; d++) {
                        int nr = pos.r + deltas[(m.dir + d) % 8][0];
                        int nc = pos.c + deltas[(m.dir + d) % 8][1];
                        if (isIn(nr, nc) && !movable[nr][nc]) {
                            m.pos = new Position(nr, nc);
                            m.dir = (m.dir + d) % 8;
                            waitingList.add(m);
                            map[r][c].remove(i--);
                            break;
                        }
                    }
                }
            }
        }
        for (Monster m : waitingList) {
            Position pos = m.pos;
            map[pos.r][pos.c].add(m);
        }
    }
    
    static void packManMove() {
        int maxCnt = -1;
        int[][] mosterMap = counting();
        boolean[][] visited = new boolean[4][4];
        int[][] deathNote = new int[3][2];
        for (int i = 0; i < 8; i += 2) {
            int cnt1 = 0;
            int nr1 = packMan.r + deltas[i][0];
            int nc1 = packMan.c + deltas[i][1];
            if (!isIn(nr1, nc1)) continue;
            cnt1 = mosterMap[nr1][nc1];
            if(cnt1 > 0) visited[nr1][nc1] = true;
            for (int j = 0; j < 8; j += 2) {
                int cnt2 = 0;
                int nr2 = nr1 + deltas[j][0];
                int nc2 = nc1 + deltas[j][1];
                if (!isIn(nr2, nc2)) continue;
                if(!visited[nr2][nc2])
                    cnt2 = mosterMap[nr2][nc2];
                if(cnt2 > 0) visited[nr2][nc2] = true;
                for (int k = 0; k < 8; k += 2) {
                    int cnt3 = 0;
                    int nr3 = nr2 + deltas[k][0];
                    int nc3 = nc2 + deltas[k][1];
                    if (!isIn(nr3, nc3)) continue;
                    if(!visited[nr3][nc3])
                        cnt3 = mosterMap[nr3][nc3];
                    int cnt = cnt1 + cnt2 + cnt3;
                    
                    if (maxCnt < cnt) {
                        maxCnt = cnt;
                        deathNote = new int[][]{{nr1, nc1}, {nr2, nc2}, {nr3, nc3}};
                    }

                }
                visited[nr2][nc2] = false;
            }
            visited[nr1][nc1] = false;
        }
        
        for (int i = 0; i < 3; i++) {
            int r = deathNote[i][0];
            int c = deathNote[i][1];
            for (Monster m : map[r][c]) {
                if (m.status == 0) {
                    m.status = -1;
                    m.deadCnt = 3;
                }
            }
        }
        packMan.r = deathNote[2][0];
        packMan.c = deathNote[2][1];
    }
    
    static void hatch() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (Monster m : map[r][c]) {
                    if (m.status == 1) m.status = 0;
                }
            }
        }
    }
    
    static void exorcist() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (int i = 0; i < map[r][c].size(); i++) {
                    Monster m = map[r][c].get(i);
                    if (m.deadCnt > 0) m.deadCnt--;
                    if (m.deadCnt == 0) {
                        map[r][c].remove(i--);
                    }
                }
            }
        }
    }
    
    static int countMonster() {
        int cnt = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (Monster m : map[r][c]) {
                    if (m.status == 0) cnt++;
                }
            }
        }
        return cnt;
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }
    
    static boolean[][] isMovable() {
        boolean[][] temp = new boolean[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (Monster m : map[r][c]) {
                    if (m.status < 0) {
                        temp[r][c] = true;
                        break;
                    }
                }
            }
        }
        temp[packMan.r][packMan.c] = true;
        return temp;
    }
    
    static boolean isMovable(int nr, int nc) {
        if (nr == packMan.r && nc == packMan.c) return false;
        List<Monster> monsterList = map[nr][nc];
        for (Monster m : monsterList) {
            if (m.status < 0) return false;
        }
        return true;
    }
    
    static int countMonster(int r, int c) {
        int cnt = 0;
        for (Monster m : map[r][c]) {
            if (m.status == 0) cnt++;
        }
        return cnt;
    }
    
    static int[][] counting(){
        int[][] temp = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (Monster m : map[r][c]) {
                    if (m.status == 0)
                        temp[r][c]++;
                }
            }
        }
        return temp;
    }
}
