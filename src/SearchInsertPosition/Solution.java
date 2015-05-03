package SearchInsertPosition;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(nums[l] < target){
            return l + 1;
        }else{
            return l;
        }
    }
}
