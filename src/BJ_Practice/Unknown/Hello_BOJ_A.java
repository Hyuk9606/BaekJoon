package BJ_Practice.Unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hello_BOJ_A {
    static int N, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + 1;
        d = Integer.parseInt(st.nextToken());
        int maximum = (int) Math.pow(d, d);
        int minimum = getMinimum(d);

        if (N >= maximum) {
            System.out.println(-1);     // 최대 초과 => -1
        } else if (N < minimum) {
            System.out.println(minimum);    // 최소보다 작으면 만들 수 있는 가장 작은 수
        } else {
            while (N < maximum && !conversion(N++, d)) ;    // 1씩 늘려가며 확인
            if (N >= maximum) {
                System.out.println(-1);
                return;
            }
            System.out.println(N - 1);
        }
    }

    // n진수로 변환한 값이 조건을 만족하는지를 리턴
    public static boolean conversion(int number, int N) {
        StringBuilder sb = new StringBuilder();
        int[] check = new int[N];
        while (number > 0) {
            if (number % N < 10) {
                check[number % N]++;
                sb.append(number % N);
                if (check[number % N] > 1) {
                    return false;
                }
            }
            number /= N;
        }
        return true;
    }

    // 10진수로 만든 int 값을 리턴
    public static int converse_ten(String number, int N) {
        char[] nums = number.toCharArray();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = ans * N + (nums[i] - '0');

        }
        return ans;
    }

    public static int getMinimum(int d) {
        String str = "10";
        for (int i = str.length(); i < d; i++) {
            str += i;
        }
        return converse_ten(str, d);
    }
}
