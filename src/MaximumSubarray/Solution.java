package MaximumSubarray;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        int max = nums[i++];
        int cur = max;
        while(i < nums.length){
            if(cur < 0) cur = 0;
            cur += nums[i++];
            if(cur > max) max = cur;
        }
        return max;
    }
}
