package HouseRobber;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int rob(int[] nums) {
        int on = 0;
        int off = 0;

        for(int i = 0; i < nums.length; ++i){
            int cur = nums[i];
            int non = off + cur;
            int noff = on > off ? on : off;
            on = non;
            off = noff;
        }

        return on > off ? on : off;
    }
}
