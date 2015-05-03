package ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] + nums[1];
        int closest = nums[0] + nums[1] + nums[2];
        if(nums.length == 3) return closest;
        int mdist = Math.abs(closest - target);
        Arrays.sort(nums);
        for(int a = 0; a < nums.length; ++a){
            int b = a + 1;
            int c = nums.length - 1;
            while(b < c){
                int s4 = nums[a] + nums[b] + nums[c] - target;
                if(s4 == 0){
                    return target;
                }else if(s4 > 0){
                    if(s4 < mdist){
                        mdist = s4;
                        closest = s4 + target;
                    }
                    --c;
                }else{
                    if(mdist + s4 > 0){
                        mdist = -s4;
                        closest = s4 + target;
                    }
                    ++b;
                }
            }
        }
        return closest;
    }
}
