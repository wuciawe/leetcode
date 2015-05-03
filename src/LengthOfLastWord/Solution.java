package LengthOfLastWord;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for(int i = s.length() - 1; i >= 0; --i){
            if(' ' == s.charAt(i)){
                if(res > 0){
                    return res;
                }
            }else{
                ++res;
            }
        }
        return res;
    }
}
