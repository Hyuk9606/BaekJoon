package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//그룹, 크기, 주변과 맞닿은 갯수
// 회전
public class G3_예술성 {
    static int N;
    static int[][] originMap;
    static int[][] map;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static GroupInfo[] groupInfos = null;
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class GroupInfo {
        int num;
        int count;
        Map<Integer, Integer> adjCount = new HashMap<>();
        
        public GroupInfo(int num) {
            this.num = num;
        }
        
        @Override
        public String toString() {
            return "GroupInfo{" +
                    "num=" + num +
                    ", count=" + count +
                    ", adjCount=" + adjCount +
                    "}\n";
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        originMap = new int[N][N];
        map = new int[N][N];
        int answer = 0;
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                originMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        init();
        grouping();
        checkGroupInfo();
        answer += calcAnsemblePoint();
        for (int i = 0; i < 3; i++) {
            lotate();
            init();
            grouping();
            checkGroupInfo();
            answer += calcAnsemblePoint();
        }
        
        System.out.println(answer);
        
    }
    
    static void init() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = originMap[r][c] - 100;
            }
        }
        groupInfos = new GroupInfo[N*N+1];
    }
    
    static void grouping() {
        boolean[][] visited = new boolean[N][N];
        Queue<Position> queue = new LinkedList<>();
        int numbering = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    int current = map[r][c];
                    queue.offer(new Position(r, c));
                    map[r][c] = ++numbering;
                    groupInfos[numbering] = new GroupInfo(current + 100);
                    visited[r][c] = true;
                    while (!queue.isEmpty()) {
                        Position temp = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = temp.r + deltas[d][0];
                            int nc = temp.c + deltas[d][1];
                            if (isIn(nr, nc) && map[nr][nc] == current && !visited[nr][nc]) {
                                queue.offer(new Position(nr, nc));
                                map[nr][nc] = numbering;
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        
    }
    
    static void checkGroupInfo() {
        boolean[][] visited = new boolean[N][N];
        Queue<Position> queue = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    int num = map[r][c];
                    GroupInfo groupinfo = groupInfos[num];
                    queue.offer(new Position(r, c));
                    visited[r][c] = true;
                    int count = 1;
                    
                    while (!queue.isEmpty()) {
                        Position temp = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = temp.r + deltas[d][0];
                            int nc = temp.c + deltas[d][1];
                            if (isIn(nr, nc) && !visited[nr][nc]) {
                                if (map[nr][nc] == num) {
                                    queue.offer(new Position(nr, nc));
                                    visited[nr][nc] = true;
                                    count++;
                                } else {
                                    groupinfo.adjCount.put(map[nr][nc], groupinfo.adjCount.getOrDefault(map[nr][nc], 0) + 1);
                                }
                            }
                        }
                    }
                    groupinfo.count = count;
//                    groupInfos[num] = groupinfo;
                }
            }
        }
    }
    
    static int calcAnsemblePoint() {
        int ansemblePoint = 0;
        for (int i = 0; i < groupInfos.length; i++) {
            if (groupInfos[i] == null) continue;
            GroupInfo groupInfo = groupInfos[i];
            int result = 1;
            for (Map.Entry<Integer, Integer> e : groupInfo.adjCount.entrySet()) {
                int adjGroup = e.getKey();
                result = groupInfo.count + groupInfos[adjGroup].count;
                result *= groupInfo.num * groupInfos[adjGroup].num * e.getValue();
                ansemblePoint += result;
            }
        }
        return ansemblePoint;
    }
    
    static void lotate() {
        int mid = N / 2;
        cross(mid);
        rectangle(mid);
    }
    
    static void cross(int mid) {
        int[] temp = new int[N];
        
        for (int i = 0; i < N; i++) {
            temp[i] = originMap[i][mid];
            originMap[i][mid] = originMap[mid][N - i - 1];
        }
        for (int i = 0; i < N; i++) {
            originMap[mid][i] = temp[i];
        }
    }
    
    static void rectangle(int mid) {
        rectangleInternal(0, 0, mid);
        rectangleInternal(mid + 1, 0, mid);
        rectangleInternal(0, mid + 1, mid);
        rectangleInternal(mid + 1, mid + 1, mid);
    }
    
    static void rectangleInternal(int r, int c, int mid) {
        int[][] temp = new int[mid][mid];
        
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                temp[i][j] = originMap[r + i][c + j];
            }
        }
        
        int rIndex = 0;
        for (int j = c + mid - 1; j >= c; j--) {
            int cIndex = 0;
            for (int i = r; i < r + mid; i++) {
                originMap[i][j] = temp[rIndex][cIndex++];
            }
            rIndex++;
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    
}


