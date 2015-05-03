package Roman2Int;

import java.util.HashMap;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    final private static int[] map;

    static {
        map = new int['X' + 1];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }

    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] map = new int['X' + 1];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        StringBuilder sb = new StringBuilder(s);
        final int len = sb.length();
        int result = map[sb.charAt(len - 1)];
        int prev = result;
        int idx = len - 2;
        while(idx >= 0){
            int cur = map[sb.charAt(idx--)];
            if(cur >= prev)
                result += cur;
            else
                result -= cur;
            prev = cur;
        }
        return result;
    }
}
