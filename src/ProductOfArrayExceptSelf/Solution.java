package ProductOfArrayExceptSelf;

/**
 * Created by haha on 2015/7/23.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
//        mul(nums, res, 0, 1);
        res[0] = 1;
        for(int i = 1; i < nums.length; ++i){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    private int mul(int[] nums, int[] res, int index, int left){
        int right = 1;
        if(index < nums.length - 1)
            right = mul(nums, res, index + 1, left * nums[index]);
        res[index] = left * right;
        return nums[index] * right;
    }
}
