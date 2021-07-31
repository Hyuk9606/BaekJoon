package BJ_Practice.Unknown;

import java.io.*;
import java.util.*;

public class BJ_1431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] serial = new String[num];
        for(int i=0;i<num;i++) {
            serial[i] = sc.next();
        }

        Arrays.sort(serial, (s1,s2) -> {
                if(s1.length() == s2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;
                    for(int i=0;i<s1.length();i++) {
                        char c1 = s1.charAt(i);
                        char c2 = s2.charAt(i);
                        if(c1<65)
                            sum1+=c1;
                        if(c2<65)
                            sum2+=c2;
                    }
                    if(sum1 == sum2) {
                        return s1.compareTo(s2);
                    }
                    else {
                        return Integer.compare(sum1, sum2);
                    }
                }
                else {
                    return Integer.compare(s1.length(), s2.length());
                }
        });

        for(int i=0;i<serial.length;i++) {
            System.out.println(serial[i]);
        }
    }

}
