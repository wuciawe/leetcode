package HouseRobberII;

/**
 * Created by haha on 2015/6/7.
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else return Math.max(solver(nums, 0, nums.length - 1), solver(nums, 1, nums.length));
    }

    int solver(int[] nums, int beg, int end){
        int on = 0;
        int off = 0;

        for(int i = beg; i < end; ++i){
            int cur = nums[i];
            int non = off + cur;
            int noff = on > off ? on : off;
            on = non;
            off = noff;
        }

        return on > off ? on : off;
    }
}
