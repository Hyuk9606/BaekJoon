class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = "";
        str = s.replaceAll("zero","0");
        str = str.replaceAll("one","1");
        str = str.replaceAll("two","2");
        str = str.replaceAll("three","3");
        str = str.replaceAll("four","4");
        str = str.replaceAll("five","5");
        str = str.replaceAll("six","6");
        str = str.replaceAll("seven","7");
        str = str.replaceAll("eight","8");
        str = str.replaceAll("nine","9");
        answer = Integer.valueOf(str);
        return answer;
    }
}