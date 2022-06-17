class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int day = 6;
        for(int m=1; m < a; m++){
            switch(m){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    day += 31;
                    break;
                case 2:
                    day += 29;
                    break;
                default:
                    day += 30;
            }
        }
        day += b;
        day %= 7;
        
        answer = week[day];        
        
        return answer;
    }
}