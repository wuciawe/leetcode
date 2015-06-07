package KthLargestElementInArray;

/**
 * Created by haha on 2015/6/7.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) return nums[pos];
            if (pos > k - 1) right = pos - 1;
            else left = pos + 1;
        }
    }

    int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left + 1, r = right;
        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                int t = nums[l];
                nums[l++] = nums[r];
                nums[r--] = t;
            }
            if(nums[l] >= pivot) ++l;
            if(nums[r] <= pivot) --r;

        }
        int t = nums[left];
        nums[left] = nums[r];
        nums[r] = t;
        return r;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4};
        Solution sol = new Solution();
        sol.findKthLargest(arr, 2);
    }
}
