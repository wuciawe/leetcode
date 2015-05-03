package LongestPalindromicSubString;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len == 0 || len == 1) return s;
        int start, end;
        int lp, rp;
        double radius;
        if(len % 2 == 1){
            int cr = 1;
            int center = len / 2;
            while(center - cr >= 0 && s.charAt(center - cr) == s.charAt(center + cr)){
                ++cr;
            }
            start = center - cr + 1;
            end = center + cr;
            radius = cr - 0.5;
            lp = center - 1;
            rp = center + 1;
        }else{
            rp = len / 2;
            lp = rp - 1;
            int cr = 1;
            while(lp - cr >= 0 && s.charAt(lp - cr) == s.charAt(lp + cr)){
                ++cr;
            }
            --cr;
            start = lp - cr;
            end = lp + cr + 1;
            radius = cr + 0.5;
            cr = 1;
            while(rp + cr <= len - 1 && s.charAt(rp - cr) == s.charAt(rp + cr)){
                ++cr;
            }
            if(cr - 0.5 > radius){
                --cr;
                start = rp - cr;
                end = rp + cr + 1;
                radius = cr + 0.5;
            }
            cr = 0;
            while(lp - cr >= 0 && s.charAt(lp - cr) == s.charAt(lp + cr + 1)){
                ++cr;
            }
            if(cr > radius){
                radius = cr;
                start = lp - cr + 1;
                end = lp + cr + 1;
            }

            --lp;
            ++rp;
        }
        while(lp - radius > -1){
            int cr = 1;
            int Intr = (int)radius;
            if(lp-Intr >= 0 && s.charAt(lp - Intr) == s.charAt(lp + Intr)){
                while(lp - cr >= 0 && s.charAt(lp - cr) == s.charAt(lp + cr)){
                    ++cr;
                }
            }
            if(cr - 0.5 > radius){
                --cr;
                start = lp - cr;
                end = lp + cr + 1;
                radius = cr + 0.5;
                Intr = cr;
            }
            cr = 1;
            if(lp-Intr >= 0 && s.charAt(rp - Intr) == s.charAt(rp + Intr)){
                while(rp + cr <= len - 1 && s.charAt(rp - cr) == s.charAt(rp + cr)){
                    ++cr;
                }
            }
            if(cr - 0.5 > radius){
                --cr;
                start = rp - cr;
                end = rp + cr + 1;
                radius = cr + 0.5;
                Intr = cr;
            }
            cr = 0;
            if(lp - Intr >= 0 && s.charAt(lp - Intr) == s.charAt(lp + Intr + 1)){
                while(lp - cr >= 0 && s.charAt(lp - cr) == s.charAt(lp + cr + 1)){
                    ++cr;
                }
            }
            if(cr > radius){
                radius = cr;
                start = lp - cr + 1;
                end = lp + cr + 1;
                Intr = cr;
            }
            cr = 0;
            if(lp - Intr >= 0 && s.charAt(rp - Intr - 1) == s.charAt(rp + Intr)){
                while(lp - cr >= 0 && s.charAt(rp - cr - 1) == s.charAt(rp + cr)){
                    ++cr;
                }
            }
            if(cr > radius){
                radius = cr;
                start = rp - cr;
                end = rp + cr;
            }
            --lp;
            ++rp;
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("adam");
    }
}
