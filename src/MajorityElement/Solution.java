package MajorityElement;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int major = 0;
        for(int n : nums){
            if(cnt == 0){
                ++cnt;
                major = n;
            }else if(n == major){
                ++cnt;
            }else{
                --cnt;
            }
        }
        return major;
    }
}
