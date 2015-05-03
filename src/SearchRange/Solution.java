package SearchRange;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int p = bs(nums, target, 0, nums.length - 1);
        if(p == -1){
            return new int[]{-1, -1};
        }else{
            return new int[]{lb(nums, target, 0, p - 1, p), rb(nums, target, p + 1, nums.length - 1, p)};
        }
    }

    private int bs(int[] nums, int target, int l, int r){
        if(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target){
                return bs(nums, target, l, mid - 1);
            }else{
                return bs(nums, target, mid + 1, r);
            }
        }else if(l == r){
            return nums[l] == target ? l : -1;
        }else{
            return -1;
        }
    }

    private int lb(int[] nums, int target, int l, int r, int b){
        if(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return lb(nums, target, l, mid - 1, mid);
            }else{
                return lb(nums, target, mid + 1, r, b);
            }
        }else if(l == r){
            return nums[l] == target ? l : b;
        }else{
            return b;
        }
    }

    private int rb(int[] nums, int target, int l, int r, int b){
        if(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return rb(nums, target, mid + 1, r, mid);
            }else{
                return rb(nums, target, l, mid - 1, b);
            }
        }else if(l == r){
            return nums[l] == target ? l : b;
        }else{
            return b;
        }
    }
}
