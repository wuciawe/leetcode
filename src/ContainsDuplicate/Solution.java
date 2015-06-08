package ContainsDuplicate;

import java.util.HashSet;

/**
 * Created by haha on 2015/6/8.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
