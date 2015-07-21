package MajorityElementII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/7/21.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0, cnt1 = 0, cnt2 = 0;
        for(int num: nums){
            if(cnt1 == 0){
                ++ cnt1;
                num1 = num;
            }else if(num == num1){
                ++ cnt1;
            }else if(cnt2 == 0){
                ++ cnt2;
                num2 = num;
            }else if(num == num2){
                ++ cnt2;
            }else{
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = cnt2 = 0;
        for(int num: nums){
            if(num == num1){
                ++ cnt1;
            }else if(num == num2){
                ++ cnt2;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(cnt1 > nums.length / 3) res.add(num1);
        if(cnt2 > nums.length / 3) res.add(num2);
        return res;
    }
}
