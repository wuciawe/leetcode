package ScrambleString;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len == 0) return true;

        boolean[][][] record = new boolean[len][len][len + 1];
        for(int i = len - 1; i >= 0; --i){
            for(int j = len - 1; j >= 0; --j){
                record[i][j][1] = s1.charAt(i) == s2.charAt(j);
                for(int l = 2; i + l <= len && j + l <= len; ++l){
                    for(int n = 1; n < l; ++n){
                        boolean r = record[i][j][n] && record[i + n][j + n][l - n] || record[i][j + l - n][n] && record[i + n][j][l - n];
                        if(r){
                            record[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }

        return record[0][0][len];
    }
}
