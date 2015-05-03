package FindPeakElement;

import java.util.List;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 0) return -1;
        if(len == 1 || nums[0] > nums[1]) return 0;
        if(nums[len - 1] > nums[len - 2]) return len - 1;
        for(int i = 1; i < len - 1; ++i){
            if(nums[i] > nums[i + 1]) return i;
        }
        return -1;
    }
}
