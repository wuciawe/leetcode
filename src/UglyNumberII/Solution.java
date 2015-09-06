package UglyNumberII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        List<Integer> uglyList = new ArrayList<>();
        uglyList.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while(uglyList.size() < n){
            int u2 = uglyList.get(i2) * 2, u3 = uglyList.get(i3) * 3, u5 = uglyList.get(i5) * 5;
            int ugly = Math.min(Math.min(u2, u3), u5);
            uglyList.add(ugly);
            if(u2 == ugly) ++i2;
            if(u3 == ugly) ++i3;
            if(u5 == ugly) ++i5;
        }
        return uglyList.get(n - 1);
    }
}
