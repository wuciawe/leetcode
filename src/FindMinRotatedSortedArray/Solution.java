package FindMinRotatedSortedArray;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int lo, int hi){
        if(hi - lo < 2) return Math.min(nums[lo], nums[hi]);
        int mid = lo + (hi - lo) / 2;
        if(nums[lo] < nums[hi]){
            return nums[lo];
        }else{
            if(nums[mid] > nums[hi]){
                return find(nums, mid, hi);
            }else{
                return find(nums, lo, mid);
            }
        }
    }
}
