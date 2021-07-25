package BJ_Practice;

public class X_BJ_1011 {
	static int step = 0;

	public static int calc(int num) {
		if(num == 1) return 1;
		int A = (int)Math.sqrt(num);
		if(A*A == num)
			return A*A-1;
		else {
			return calc(num-A*A)-1;
		}
		
		
	}

	public static void main(String[] args) {
		int num = 2;
		step+= calc(num);
		System.out.println(step);
	}
}
