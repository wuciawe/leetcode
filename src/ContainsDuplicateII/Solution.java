package ContainsDuplicateII;

import java.util.HashSet;

/**
 * Created by haha on 2015/6/8.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        for(; i <= k && i < nums.length; ++i){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        for(; i < nums.length; ++i){
            set.remove(nums[i - k - 1]);
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
