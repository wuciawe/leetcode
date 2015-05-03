package ClimbingStairs;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int climbStairs(int n) {
        int res = n;
        int two = 1;
        int one = 2;
        for(int i = 3; i <= n; ++i){
            res = one + two;
            two = one;
            one = res;
        }
        return res;
    }

}
