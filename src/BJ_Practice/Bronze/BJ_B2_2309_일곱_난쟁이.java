package BJ_Practice.Bronze;

import java.util.*;

public class BJ_B2_2309_일곱_난쟁이{
	static int [] arr = new int[9];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
        comb(0,0);
    }
    
    static int[] selected = new int[7];
    static void comb(int cnt, int start) {
    	if(cnt == 7) {
//    		System.out.println(Arrays.toString(selected));
    		int sum = 0;
    		for (int i = 0; i < 7 ; i++) {
				sum += selected[i];
			}
    		if(sum == 100) {
    			Arrays.sort(selected);
    			for (int i = 0; i < 7 ; i++) {
					System.out.println(selected[i]);
				}
    			System.exit(0);
    		}
    		return;
    	}
//    	if(start == 2) return ;
    	for (int i = start; i < 9 ; i++) {
			selected[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
    }
    
}