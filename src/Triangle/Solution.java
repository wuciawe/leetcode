package Triangle;

import java.util.List;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if(rows == 0) return 0;
        int[] res = new int[rows];
        for(int row = 0; row < rows; ++row){
            List<Integer> l = triangle.get(row);
            for(int c = row; c > 0; --c){
                if(c == row){
                    res[c] = l.get(c) + res[c - 1];
                }else{
                    res[c] = l.get(c) + Math.min(res[c - 1], res[c]);
                }
            }
            res[0] += l.get(0);
        }
        int min = res[0];
        for(int i = 1; i < rows; ++i){
            if(res[i] < min){
                min = res[i];
            }
        }
        return min;
    }
}
