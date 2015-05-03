package SearchInRotatedSortedArray;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                if(target == nums[l]){
                    return l;
                }else if(nums[l] < nums[mid]){
                    if(target > nums[l]){
                        ++l;
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }else{
                    ++l;
                    r = mid - 1;
                }
            }else{
                if(target == nums[r]){
                    return r;
                }else if(nums[r] > nums[mid]){
                    if(target > nums[r]){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                        --r;
                    }
                }else{
                    --r;
                    l = mid + 1;
                }
            }
        }

        return nums[l] == target ? l : -1;
    }
}
