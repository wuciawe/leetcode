package SearchInRotatedSortedArrayII;

import java.lang.annotation.Target;
import java.util.TreeMap;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0] && target > nums[nums.length - 1]) return false;
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(r - l < 5){
                for(int i = l; i <= r; ++i){
                    if(nums[i] == target) return true;
                }
                return false;
            }
            int mid = l + (r - l) / 2;
            int M = nums[mid];
            if(M == target) return true;
            int L = nums[l];
            int R = nums[r];
            if(M > target){
                if(M == R){
                    if(L == R){
                        ++l;
                        --r;
                    }else if(L > R){
                        l = mid + 1;
                        --r;
                    }else{
                        r = mid - 1;
                    }
                }else if(M > R){
                    if(R == target){
                        return true;
                    }else if(R < target){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }else if(M < R){
                    r = mid - 1;
                }
            }else{
                if(M == R){
                    if(L == R){
                        ++l;
                        --r;
                    }else if(L > R){
                        r = mid - 1;
                    }else{
                        return false;
                    }
                }else if(M > R){
                    l = mid + 1;
                }else if(M < R){
                    if(L == target){
                        return true;
                    }else if(L < target && R < target){
                        ++l;
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
            }
        }
        return l < nums.length && nums[l] == target || r >= 0 && nums[r] == target;
    }
}
