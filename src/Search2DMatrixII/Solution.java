package Search2DMatrixII;

/**
 * Created by haha on 2015/7/24.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        else return search(matrix, target, 0, 0, matrix.length, matrix[0].length, new boolean[matrix.length][matrix[0].length]);
    }

    private boolean search(int[][] matrix, int target, int w, int h, int width, int height, boolean[][] mask){
        if(w == width || h == height || mask[w][h]) return false;
        int n = matrix[w][h];
        mask[w][h] = true;
        if(n < target){
            return search(matrix, target, w + 1, h, width, height, mask) || search(matrix, target, w, h + 1, width, height, mask);
        } else {
            return n == target;
        }
    }
}
