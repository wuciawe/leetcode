package SingleNumber;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for(int n : nums){
            r ^= n;
        }
        return r;
    }
}
