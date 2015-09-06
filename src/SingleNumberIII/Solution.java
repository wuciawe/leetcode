package SingleNumberIII;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public int[] singleNumber(int[] nums){
        int diff = 0;
        for(int num : nums){
            diff ^= num;
        }
        diff &= -diff;
        int[] res = {0, 0};
        for(int num : nums){
            if(0 == (diff & num)){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
