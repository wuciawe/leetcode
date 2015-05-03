package MaxProductSubarray;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int pos = 0, neg = 0, res = nums[0];
        for(int num: nums){
            if(num > 0){
                int np = pos * num;
                pos = np > num ? np : num;
                if(pos > res) res = pos;
                neg *= num;
            }else if(num < 0){
                int nn = pos * num;
                pos = neg * num;
                neg = nn > num ? num : nn;
                if(pos > res && pos != 0) res = pos;
            }else{
                pos = 0;
                neg = 0;
                if(res < 0) res = 0;
            }
        }
        return res;
    }
}
