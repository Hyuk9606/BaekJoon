package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_병원_거리_최소화하기 {
    static int N, M;
    static int[][] map;
    static int peopleSize = 0, hospitalSize = 0;
    static List<Hospital> hospitals = new ArrayList<>();
    static List<Person> people = new ArrayList<>();
    
    static class Position {
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Hospital extends Position {
        int no;
        
        public Hospital(int no, int r, int c) {
            super(r, c);
            this.no = no;
        }
    }
    
    static class Person extends Position {
        int no;
        int[] distance = new int[13];
        
        public Person(int no, int r, int c) {
            super(r, c);
            this.no = no;
            Arrays.fill(distance, -1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) people.add(new Person(peopleSize++, r, c));
                else if (map[r][c] == 2) hospitals.add(new Hospital(hospitalSize++, r, c));
            }
        }
        checkDist();
        getMinDistHospital();
        System.out.println();
    }
    
    static void checkDist() {
        for (int p = 0; p < people.size(); p++) {
            Person person = people.get(p);
            for (int h = 0; h < hospitals.size(); h++) {
                Hospital hospital = hospitals.get(h);
                int dist = Math.abs(hospital.r - person.r) + Math.abs(hospital.c - person.c);
                person.distance[hospital.no] = dist;
            }
        }
    }
    
    static void getMinDistHospital() {
        Set<Integer> hospitalCandidates = new HashSet<>();
        for (int p = 0; p < people.size(); p++) {
            int[] distArray = people.get(p).distance;
            int hospitalNo = 0;
            int minDist = 9999;
            for (int i = 0; i < hospitalSize; i++) {
                if(minDist > distArray[i]){
                    minDist = distArray[i];
                    hospitalNo = i;
                }
            }
            hospitalCandidates.add(hospitalNo);
        }
        System.out.println();
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
