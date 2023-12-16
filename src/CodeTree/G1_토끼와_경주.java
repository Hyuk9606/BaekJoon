package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_토끼와_경주 {
    static int Q;
    static int N, M, P;
    static int K, S;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Map<Integer, Rabit> map = new HashMap<>();
    static PriorityQueue<Rabit> pq = new PriorityQueue<>(new Comparator<Rabit>() {
        @Override
        public int compare(Rabit o1, Rabit o2) {
            if (o1.jumpCount == o2.jumpCount) {
                int value = getPriority(o1.pos, o2.pos, 1);
                if (value == 0) {
                    return Integer.compare(o1.pid, o2.pid);
                }
                return value;
            }
            return Integer.compare(o1.jumpCount, o2.jumpCount);
        }
    });
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            int type = input(new StringTokenizer(br.readLine()));
            switch (type) {
                case 2:
                    for (; K > 0; K--) {
                        Rabit rabit = pq.poll();
                        rabit.jumpCount++;
                        rabit.elected = true;
                        rabit.pos = getDestination(rabit);
                        int score = rabit.pos.r + rabit.pos.c;
                        map.forEach((k, v) -> {
                            if (k != rabit.pid) {
                                v.score += score;
                            } else {
                                v.pos = rabit.pos;
                            }
                        });
                        pq.offer(rabit);
                    }
                    addScore();
            }
        }
    }
    
    static public int input(StringTokenizer st) {
        String type = st.nextToken();
        switch (type) {
            case "100":
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                P = Integer.parseInt(st.nextToken());
                for (int p = 0; p < P; p++) {
                    int pid = Integer.parseInt(st.nextToken());
                    int d = Integer.parseInt(st.nextToken());
                    Rabit r = new Rabit(pid, d, new Position(1, 1), 0);
                    map.put(pid, r);
                    pq.offer(r);
                }
                return 1;
            case "200":
                K = Integer.parseInt(st.nextToken());
                S = Integer.parseInt(st.nextToken());
                return 2;
            case "300":
                int pid = Integer.parseInt(st.nextToken());
                map.get(pid).d *= Integer.parseInt(st.nextToken());
                return 3;
            case "400":
                System.out.println(getMaxScore());
                return 4;
        }
        return 4;
    }
    
    static Position getDestination(Rabit rabit) {
        int pid = rabit.pid;
        rabit.d = map.get(pid).d;
        Position[] positions = new Position[4];
        for (int dir = 0; dir < 4; dir++) {
            positions[dir] = new Position(rabit.pos.r + deltas[dir][0] * rabit.d, rabit.pos.c + deltas[dir][1] * rabit.d);
            positions[dir] = normalize(positions[dir], dir);
        }
        return getPriorPosition(positions);
    }
    
    static Position normalize(Position p, int dir) {
        if (dir % 2 == 1) {
            if (p.r <= 0) p.r = Math.abs(p.r - 2);
            p.r %= (N - 1) * 2;
            if (p.r > N) {
                p.r = N - (p.r - N);
            }
            if (p.r == 0) p.r = 2;
        } else {
            if (p.c <= 0) p.c = Math.abs(p.c - 2);
            p.c %= (M - 1) * 2;
            if (p.c > M) {
                p.c = M - (p.c - M);
            }
            if (p.c == 0) p.c = 2;
        }
        return new Position(p.r, p.c);
    }
    
    static public int getPriority(Position pos1, Position pos2, int type) {
        if (pos1.r + pos1.c == pos2.r + pos2.c) {
            if (pos1.r == pos2.r) {
                if (pos1.c == pos2.c) {
                    return 0;
                }
                return Integer.compare(pos1.c, pos2.c) * type;
            }
            return Integer.compare(pos1.r, pos2.r) * type;
        }
        return Integer.compare(pos1.r + pos1.c, pos2.r + pos2.c) * type;
    }
    
    static Position getPriorPosition(Position[] positions) {
        Position first, second;
        if (getPriority(positions[0], positions[1], -1) < 0) {
            first = positions[0];
        } else first = positions[1];
        if (getPriority(positions[2], positions[3], -1) < 0) {
            second = positions[2];
        } else second = positions[3];
        
        if (getPriority(first, second, -1) < 0) {
            return first;
        }
        return second;
    }
    
    static void addScore() {
        PriorityQueue<Rabit> tempPq = new PriorityQueue<>(new Comparator<Rabit>() {
            @Override
            public int compare(Rabit o1, Rabit o2) {
                int value = getPriority(o1.pos, o2.pos, -1);
                if (value == 0) {
                    return Integer.compare(o1.pid, o2.pid) * -1;
                }
                return value;
            }
        });
        map.forEach((k, v) -> {
            if(v.elected)
                tempPq.offer(v);
            v.elected = false;
        });
        Rabit rabit = tempPq.poll();
        map.get(rabit.pid).score += S;
    }
    
    static long getMaxScore() {
        long max = 0;
        for (Rabit rabit : map.values()) {
            max = Math.max(max, rabit.score);
        }
        return max;
    }
    
    static class Rabit {
        int pid, d;
        Position pos;
        int jumpCount;
        long score;
        boolean elected;
        
        public Rabit(int pid, int d, Position pos, int jumpCount) {
            this.pid = pid;
            this.d = d;
            this.pos = pos;
            this.jumpCount = jumpCount;
        }
    }
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
