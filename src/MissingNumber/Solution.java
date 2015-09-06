package MissingNumber;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < nums.length; ++i){
            res ^= i;
            res ^= nums[i];
        }
        return res ^ nums.length;
    }
}
