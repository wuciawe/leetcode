package CountAndSay;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        StringBuilder last = new StringBuilder("1");
        while(--n > 0){
            StringBuilder cur = new StringBuilder();
            for(int i = 0; i < last.length();){
                char ch = last.charAt(i);
                int cnt = 1;
                while(i + cnt < last.length() && last.charAt(i + cnt) == ch){
                    ++cnt;
                }
                cur.append(cnt);
                cur.append(ch);
                i += cnt;
            }
            last = cur;
        }
        return last.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(2));
    }
}
