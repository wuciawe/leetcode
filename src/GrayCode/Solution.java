package GrayCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haha on 2015/4/11.
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        int len = (int)Math.pow(2, n);
        int[] code = new int[len];
        List<Integer> res = new LinkedList<Integer>();
        res.add(0);
        for(int i = 1; i < len; ++i){
            int b = i;
            int base = 0;
            while(b % 2 == 0){
                b >>= 1;
                ++base;
            }
            code[base] ^= 1;
            base = 1;
            int result = 0;
            for(int idx = 0; idx < n; ++idx){
                result += code[idx] * base;
                base <<= 1;
            }
            res.add(result);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.grayCode(4);
    }
}
