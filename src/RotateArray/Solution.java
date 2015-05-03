package RotateArray;

import java.util.Arrays;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        int[] tmp1 = Arrays.copyOf(nums, nums.length - k);
        int[] tmp2 = new int[k];
        System.arraycopy(nums, nums.length - k, tmp2, 0, k);
        System.arraycopy(tmp2, 0, nums, 0, k);
        System.arraycopy(tmp1, 0, nums, k, nums.length - k);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rotate(new int[]{1,2,3,4,5,6,7}, 2);
    }
}
