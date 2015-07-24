package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by haha on 2015/7/24.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        for(; i < k - 1; ++i){
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.offer(i);
        }
        int[] res = new int[nums.length - k + 1];
        for(; i < nums.length; ++i){
            while(!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.offer(i);
            res[i - k + 1] = nums[q.peek()];
        }
        return res;
    }
}
