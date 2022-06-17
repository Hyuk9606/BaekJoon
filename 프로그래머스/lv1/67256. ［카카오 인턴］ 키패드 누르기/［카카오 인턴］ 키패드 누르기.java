import java.util.*;

class Solution {
    public static char[] curNum;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        curNum = new char[2];
        curNum[0] = '*';
        curNum[1] = '#';
        
        for(int number : numbers){
            answer += push(number, hand);
        }
        return answer;
    }
    
    public static String push(int num, String hand){
        switch(num){
            case 1: case 4: case 7:
                curNum[0] = Integer.toString(num).charAt(0);
                return "L";
            case 2: case 5: case 8: case 0:
                return calcDist(num,hand);
            default:
                curNum[1] = Integer.toString(num).charAt(0);
                return "R";
        }
    }
    
    public static String calcDist(int num, String hand){
        Position left = getPos(curNum[0]);
        Position right = getPos(curNum[1]);
        Position input = getPos(Integer.toString(num).charAt(0));

        int leftDist = Math.abs(input.r - left.r ) + Math.abs( input.c - left.c);
        int rightDist = Math.abs(input.r - right.r ) + Math.abs(input.c - right.c);

        if(leftDist < rightDist){
            curNum[0] = Integer.toString(num).charAt(0);
            return "L";
        }
        else if(leftDist > rightDist){
            curNum[1] = Integer.toString(num).charAt(0);
            return "R";
        }
        if(hand.equals("left")){
            curNum[0] = Integer.toString(num).charAt(0);
            return "L";
        }
        curNum[1] = Integer.toString(num).charAt(0);
        return "R";
    }
    
    public static Position getPos(char num){
        if(num == '0')
            return new Position(3,1);
        else if(0 < num - '0' && num - '0' < 10)
            return new Position((num - '0' -1)/3, (num - '0' -1)%3);
        else if (num == '*')
            return new Position(3,0);
        else
            return new Position(3,2);
    }
    
    public static class Position{
        int r,c;
        
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
        public String toString(){
            return this.r + " : " + this.c;
        }
    }
    
}