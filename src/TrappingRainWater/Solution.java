package TrappingRainWater;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public int trap(int[] height) {
        int result = 0;

        int lh = 0;
        int l = 0;
        int r = height.length - 1;

        while(l < r){
            int t = Math.min(height[l], height[r]);
            result += (t - lh) * (r - l - 1);
            lh = t;
            if(height[l] > height[r]){
                --r;
                while(l < r && height[r] <= lh){
                    result -= height[r];
                    --r;
                }
                if(l < r){
                    result -= lh;
                }
            }else{
                ++l;
                while(l < r && height[l] <= lh){
                    result -= height[l];
                    ++l;
                }
                if(l < r){
                    result -= lh;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
