package LongestConsecutiveSequence;

import java.util.HashMap;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int max = 1;
        for(int i = 0; i < nums.length; ++i){
            int cur = nums[i];
            if(cache.containsKey(cur)) continue;
            if(cache.containsKey(cur - 1)){
                int before = cache.get(cur - 1);
                if(cache.containsKey(cur + 1)){
                    int after  = cache.get(cur + 1);
                    int amt = before + after + 1;
                    if(amt > max) max = amt;
                    cache.replace(cur - before, amt);
                    cache.replace(cur + after, amt);
                    cache.put(cur, 1);
                }else{
                    int amt = before + 1;
                    if(amt > max) max = amt;
                    cache.replace(cur - before, amt);
                    cache.put(cur, amt);
                }
            }else{
                if(cache.containsKey(cur + 1)){
                    int after  = cache.get(cur + 1);
                    int amt = after + 1;
                    if(amt > max) max = amt;
                    cache.put(cur, amt);
                    cache.replace(cur + after, amt);
                }else{
                    cache.put(cur, 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3});
    }
}
