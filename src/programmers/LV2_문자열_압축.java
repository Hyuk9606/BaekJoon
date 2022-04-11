package programmers;

class LV2_문자열_압축 {
    public int solution(String s) {
        if (s.length() == 1) return 1;
        int answer = 1001;
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            answer = Math.min(check(s, i), answer);
        }
        return answer;
    }
    
    public int check(String s, int i) {
        int ans = 0;
        int cnt = 1;
        while (true) {
            String subStr = s.substring(0, i);
            s = s.substring(i, s.length());
            while (s.length() >= i && s.startsWith(subStr)) {
                cnt++;
                s = s.substring(i, s.length());
            }
            if (cnt > 1) {
                ans += String.valueOf(cnt).length();
            }
            ans += i;
            cnt = 1;
            if (s.length() <= i) {
                ans += s.length();
                break;
            }
        }
        return ans;
        
    }
}
