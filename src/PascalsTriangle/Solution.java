package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        for(int i = 0; i < numRows; ++i){
            result.add(getRow(i));
        }
        return result;
    }

    private List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex == 0){
            result.add(1);
            return result;
        }

        int[] res = new int[rowIndex / 2 + 1];
        res[0] = 1;
        for(int r = 1; r <= rowIndex; ++r){
            if(r % 2 == 0){
                res[r / 2] = 2 * res[r / 2 - 1];
            }
            for(int i = (r - 1) / 2; i > 0; --i){
                res[i] += res[i - 1];
            }
        }
        result.add(1);
        for(int i = 1; i < (rowIndex - 1) / 2 + 1; ++i){
            result.add(res[i]);
        }
        if(rowIndex % 2 == 0){
            result.add(res[rowIndex / 2]);
        }
        for(int i = (rowIndex - 1) / 2; i > 0; --i){
            result.add(res[i]);
        }
        result.add(1);
        return  result;
    }
}
