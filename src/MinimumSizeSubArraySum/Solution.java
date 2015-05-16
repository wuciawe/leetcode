package MinimumSizeSubArraySum;

/**
 * Created by haha on 2015/5/16.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        int l = 0;
        int r = 0;
        int sum = nums.length > 0 ? nums[0] : 0;

        while(r < nums.length && l <= r){
            if(sum < s && ++r < nums.length){
                sum += nums[r];
            }else{
                min = Math.min(min, r - l + 1);
                sum -= nums[l++];
            }
        }

        return min <= nums.length ? min : 0;
    }
}
