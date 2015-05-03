package DecodeWays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {

    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int res[]  = new int[len + 1];
        res[len] = 1;
        char last = s.charAt(--len);
        if(last != '0') res[len] = 1;

        while(--len >= 0){
            char ch1 = s.charAt(len);
            switch (ch1){
                case '0':
                    if(last == '0') return 0;
                    break;
                case '1':
                    res[len] = res[len + 2] + res[len + 1];
                    break;
                case '2':
                    if(last < '7') res[len] = res[len + 1] + res[len + 2];
                    else res[len] = res[len + 1];
                    break;
                default:
                    res[len] = res[len + 1];
                    break;
            }
            last = ch1;
        }

        return res[0];
    }
}
