package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_싸움땅 {
    static int N, M, K;
    static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static PriorityQueue<Integer>[][] gunMap;
    static Player[] players;
    static int[][] playerMap;
    static int[] score;
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Player {
        int num, stat, dir, gunDamage;
        Position pos;
        
        public Player(int num, int dir, int stat) {
            this.num = num;
            this.stat = stat;
            this.dir = dir;
            this.gunDamage = 0;
        }
    }
    
    public static void main(String[] args) {
        input();
    
        for (int i = 0; i < K; i++) {
            round();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    
    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            gunMap = new PriorityQueue[N + 1][N + 1];
            playerMap = new int[N + 1][N + 1];
            players = new Player[M + 1];
            score = new int[M + 1];
            
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    gunMap[r][c] = new PriorityQueue<>(Collections.reverseOrder());
                    int gunDam = Integer.parseInt(st.nextToken());
                    if (gunDam > 0) gunMap[r][c].offer(gunDam);
                }
            }
            
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                playerMap[x][y] = i;
                players[i] = new Player(i, d, s);
                players[i].pos = new Position(x, y);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void round() {
        for (int i = 1; i <= M; i++) {
            move(i);
        }
    }
    
    static void move(int i) {
        Player player = players[i];
        int nr = player.pos.r + deltas[player.dir][0];
        int nc = player.pos.c + deltas[player.dir][1];
        if (!isIn(nr, nc)) {
            player.dir = (player.dir + 2) % 4;
            nr = player.pos.r + deltas[player.dir][0];
            nc = player.pos.c + deltas[player.dir][1];
        }
        if (playerMap[nr][nc] > 0) {
            int[] result = fight(playerMap[nr][nc], player.num);
            Player winner = players[result[0]];
            score[winner.num] += result[2];
            playerMap[winner.pos.r][winner.pos.c] = 0;
            looserMove(result[1], nr, nc);
            playerMap[nr][nc] = winner.num;
            winner.pos = new Position(nr, nc);
            getGun(winner, nr, nc);
        } else {
            playerMap[player.pos.r][player.pos.c] = 0;
            playerMap[nr][nc] = player.num;
            player.pos = new Position(nr,nc);
            getGun(player, nr, nc);
        }
    }
    
    static void getGun(Player player, int r, int c) {
        if (!gunMap[r][c].isEmpty()) {
            if (player.gunDamage != 0) {
                gunMap[r][c].offer(player.gunDamage);
            }
            player.gunDamage = gunMap[r][c].poll();
        }
    }
    
    static int[] fight(int num1, int num2) {
        int winner = 0, looser = 0, score = 0;
        int num1Damage = players[num1].stat + players[num1].gunDamage;
        int num2Damage = players[num2].stat + players[num2].gunDamage;
        if (num1Damage > num2Damage) {
            winner = num1;
            looser = num2;
            score = num1Damage - num2Damage;
        } else if (num1Damage < num2Damage) {
            winner = num2;
            looser = num1;
            score = num2Damage - num1Damage;
        } else {
            winner = players[num1].stat > players[num2].stat ? num1 : num2;
            looser = winner == num1 ? num2 : num1;
            score = 0;
        }
        return new int[]{winner, looser, score};
    }
    
    static void looserMove(int num, int r, int c) {
        Player player = players[num];
        
        int gun = player.gunDamage;
        gunMap[r][c].offer(gun);
        player.gunDamage = 0;
        playerMap[player.pos.r][player.pos.c] = 0;
        for (int i = 0; i < 4; i++) {
            int dir = (player.dir + i) % 4;
            int nr = r + deltas[dir][0];
            int nc = c + deltas[dir][1];
            if (isIn(nr, nc)) {
                if (playerMap[nr][nc] == 0) {
                    playerMap[nr][nc] = num;
                    player.pos = new Position(nr, nc);
                    player.dir = dir;
                    getGun(player, nr, nc);
                    return;
                }
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }
}
