package UniqueBST;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int numTrees(int n) {
        if(n < 3) return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for(int i = 3; i <= n; ++i){
            res[i] += 2 * res[i - 1];
            for(int j = 1; j < i / 2; ++j){
                res[i] += 2 * res[j] * res[i - j - 1];
            }
            if(i % 2 != 0){
                res[i] += res[i / 2] * res[i / 2];
            }
        }
        return res[n];
    }
}
