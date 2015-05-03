package JumpGame;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int max = 0;

        for(int i = 0; i <= max; ++i){
            int r = i + nums[i];
            if(r > max){
                max = r;
                if(max >= len) return true;
            }
        }

        return max >= len;
    }
}
