package RotateImage;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int step = 0;
        while(len > 1){
            int lent = len - 1;
            int lens = step + lent;
            for(int i = 0; i < lent; ++i){
                int tmp = matrix[step][step + i];
                matrix[step][step + i] = matrix[lens - i][step];
                matrix[lens - i][step] = matrix[lens][lens - i];
                matrix[lens][lens - i] = matrix[step + i][lens];
                matrix[step + i][lens] = tmp;
            }
            ++step;
            len -= 2;
        }
    }

}
