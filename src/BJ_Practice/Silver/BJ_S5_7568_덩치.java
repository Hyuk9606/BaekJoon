package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_S5_7568_덩치 {
    static int N;
    
    static class Person {
        int no;
        int weight;
        int height;
    
        public Person(int no, int weight, int height) {
            this.no = no;
            this.weight = weight;
            this.height = height;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Person(i+1, weight, height));
        }
    
        for (int i = 0; i < N; i++) {
            Person current = list.get(i);
            int count = 1;
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                Person other = list.get(j);
                
                if(current.weight < other.weight && current.height < other.height)
                    count++;
            }
            sb.append(count).append(" ");
        }
    
        System.out.println(sb.toString());
    }
}
