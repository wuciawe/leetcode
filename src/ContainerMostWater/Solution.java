package ContainerMostWater;

/**
 * Created by haha on 2015/4/11.
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int h = 0;
        int ma = 0;

        while(l < r){
            int lh = height[l];
            int rh = height[r];
            if(lh < rh){
                h = lh;
                ma = Math.max(ma, h * (r - l));
                ++l;
                while((l < r) && (height[l] <= h)) ++l;
            }else{
                h = rh;
                ma = Math.max(ma, h * (r - l));
                --r;
                while((l < r) && (height[r] <= h)) --r;
            }
        }

        return ma;
    }
}
