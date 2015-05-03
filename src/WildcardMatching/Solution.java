package WildcardMatching;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public static boolean isMatch(String s, String p){
        return match(s, p, 0, 0);
    }

    private static boolean match(String s, String p, int si, int pi){
        if(pi == p.length()) return si == s.length();
        char cp = p.charAt(pi);
        if(cp == '*' && pi + 1 == p.length()) return true;
        if(si == s.length()) return false;
        if(cp == '*'){
            while(pi + 1 < p.length() && p.charAt(pi + 1) == '*') ++pi;
            if(match(s, p, si + 1, pi)) return true;
            if(match(s, p, si, pi + 1)) return true;
            return false;
        }else{
            if(cp == '?' || cp == s.charAt(si))
                return match(s, p, si + 1, pi + 1);
            else return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
