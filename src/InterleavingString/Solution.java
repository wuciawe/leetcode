package InterleavingString;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 + len2 != s3.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] res = new boolean[len1 + 1][len2 + 1];
        res[0][0] = true;
        for(int w = 1; w <= len2; ++w){
            res[0][w] = res[0][w - 1] && c2[w - 1] == c3[w - 1];
        }
        for(int h = 1; h <= len1; ++h){
            res[h][0] = res[h - 1][0] && c1[h - 1] == c3[h - 1];
            for(int w = 1; w <= len2; ++w){
                res[h][w] =
                        res[h - 1][w] && c1[h - 1] == c3[h + w - 1]
                        || res[h][w - 1] && c2[w - 1] == c3[h + w - 1];
            }
        }
        return res[len1][len2];
    }
}
