package MaximalRectangle;

import java.util.Stack;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int hlen = matrix.length;
        if(hlen == 0) return 0;
        int wlen = matrix[0].length;
        if(wlen == 0) return 0;

        int[] height = new int[wlen];
        for(int w = 0; w < wlen; ++w){
            height[w] = matrix[0][w] - '0';
        }

        int res = largestRectangleArea(height);

        for(int h = 1; h < hlen; ++h){
            for(int w = 0; w < wlen; ++w){
                if(matrix[h][w] == '0'){
                    height[w] = 0;
                }else{
                    ++height[w];
                }
            }
            res = Math.max(res, largestRectangleArea(height));
        }

        return res;
    }

    private int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
