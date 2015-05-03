package PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        if(n == 0) return "";
        StringBuilder res = new StringBuilder();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i < n; ++i){
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> candy = new ArrayList<Integer>(n + 1);
        for(int i = 1; i <= n; ++i){
            candy.add(i);
        }

        int f;
        int idx;
        for(int i = n; i > 0; --i){
            f = factorial[i - 1];
            idx = (k - 1) / f;
            res.append(candy.get(idx));
            candy.remove(idx);
            k = k % f;
            if(k == 0) k = f;
        }

        return res.toString();
    }
}
