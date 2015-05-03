package NQueensII;

import java.util.Arrays;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] left = new boolean[2 * n];
        boolean[] right = new boolean[2 * n];
        int[] res = new int[]{0};
        solver(res, 0, n, cols, left, right);
        return res[0];
    }

    private void solver(int[] res, int row, int N, boolean[] cols, boolean[] left, boolean[] right){
        if(row == N){
            res[0] += 1;
        }else{
            for(int col = 0; col < N; ++col){
                if(!cols[col] && !left[col - row + N] && !right[col + row]){
                    cols[col] = true;
                    left[col - row + N] = true;
                    right[col + row] = true;
                    solver(res, row + 1, N, cols, left, right);
                    cols[col] = false;
                    left[col - row + N] = false;
                    right[col + row] = false;
                }
            }
        }
    }
}
