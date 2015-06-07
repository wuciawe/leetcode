package ShortestPalindrome;

/**
 * Created by haha on 2015/6/7.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int[] record = new int[2];
        String prefix;
        if(findCenter(s, record)){
            if(record[0] == 0){
                prefix = buildPrefix(s, 2 * (record[1] + 1));
            }else{
                prefix = buildPrefix(s, 2 * record[1] + 1);
            }
        }else{
            prefix = buildPrefix(s, 1);
        }
        return prefix + s;
    }

    String buildPrefix(String s, int b){
        if(b >= s.length()) return "";
        String sr = s.substring(b);
        String res = "";
        for(char c : sr.toCharArray())
            res = c + res;
        return res;
    }

    boolean findCenter(String s, int[] record) {
        char[] cArr = s.toCharArray();
        for(int i = cArr.length / 2; i >= 0; --i){
            if(isPalindrome(cArr, i, false)){
                record[0] = 0;
                record[1] = i;
                return true;
            }
            if(isPalindrome(cArr, i, true)){
                record[0] = 1;
                record[1] = i;
                return true;
            }
        }
        return false;
    }

    boolean isPalindrome(char[] cArr, int c, boolean isOdd){
        int rb = 0;
        for(int i = 0; i < c; ++i){
            if(isOdd) rb = c + c - i;
            else rb = c + c -  i + 1;
            if(rb >= cArr.length || cArr[i] != cArr[rb]) return false;
        }
        if(!isOdd){
            if(c + 1 >= cArr.length || cArr[c] != cArr[c + 1]) return false;
        }
        return true;
    }
}
