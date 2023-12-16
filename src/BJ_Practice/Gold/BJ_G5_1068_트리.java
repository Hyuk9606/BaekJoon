package BJ_Practice.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_1068_트리 {
    static int N;
    static int[] jokbo;
    static boolean[] isLeaf;
    static int deleteNode;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jokbo = new int[N];
        isLeaf = new boolean[N];
        Arrays.fill(isLeaf, true);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            jokbo[i] = parent;
            
            if (parent != -1) {
                isLeaf[parent] = false;
            }
        }
        
        deleteNode = Integer.parseInt(br.readLine());
        ArrayList<Integer> deletedList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (isLeaf[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                int parent = i;
                boolean flag = false;
                while(parent != -1){
                    if(parent == deleteNode){
                        flag = true;
                        break;
                    }
                    stack.push(parent);
                    parent = jokbo[parent];
                }
                if(flag){
                    while(!stack.isEmpty()) {
                        deletedList.add(stack.pop());
                    }
                }
            }
        }
        for (int i = 0; i < deletedList.size(); i++) {
            isLeaf[deletedList.get(i)] = false;
        }
        
        int parent = jokbo[deleteNode];
        if(parent != -1) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (jokbo[i] == parent) {
                    count++;
                }
            }
            if (count == 1) isLeaf[parent] = true;
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(isLeaf[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
