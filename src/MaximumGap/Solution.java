package MaximumGap;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int base = 0xff + 1;
        int[] aux = new int[nums.length];

        for (int i = 0; i < 32; i += 8) {
            int[] count = new int[base + 1];

            for (int v : nums)
                ++count[((v >>> i) & 0xff) + 1];

            for (int r = 0; r < base; r++)
                count[r + 1] += count[r];

            for (int v : nums)
                aux[count[(v >>> i) & 0xff]++] = v;

            int[] t = nums;
            nums = aux;
            aux = t;
        }

        int res = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++)
            res = Math.max(nums[i] - nums[i - 1], res);

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumGap(new int[]{1, 10000000});
    }
}
