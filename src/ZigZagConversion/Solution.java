package ZigZagConversion;

/**
 * Created by haha on 2015/4/17.
 */
public class Solution {
    public String convert(String s, int nRows) {
        if(nRows <= 1) return s;
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < nRows; ++i){
            int j = 0;
            while(j - i < len){
                if(i > 0 && i < nRows - 1 && j > i){
                    sb.append(s.charAt(j - i));
                }
                if(i + j < len){
                    sb.append(s.charAt(j + i));
                }
                j += 2 * nRows - 2;
            }
        }

        return sb.toString();
    }
}
