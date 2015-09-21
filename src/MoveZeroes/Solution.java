package MoveZeroes;

/**
 * Created by haha on 2015/9/21.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int c = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0) nums[c++] = nums[i];
        }
        for(; c < nums.length; ++c){
            nums[c] = 0;
        }
    }
}
