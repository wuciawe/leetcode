package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/7/21.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean hasStart = true;
        long last = nums[0];
        long start = last;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] - last > 1){
                if(last == start){
                    res.add(Long.toString(start));
                }else{
                    res.add(start + "->" + last);
                }
                start = nums[i];
            }
            last = nums[i];
        }
        if(last == start){
            res.add(Long.toString(start));
        }else{
            res.add(start + "->" + last);
        }
        return res;
    }
}
